package com.pa.energy.service.impl;

import com.pa.energy.domain.EnergyHour;
import com.pa.energy.service.EmissionStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;
import java.util.stream.IntStream;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component("defaultEmissionStrategy")
public class DefaultEmissionStrategyImpl implements EmissionStrategy {

    @Override
    public List<EnergyHour> calculateLowestEmissionHourlyRange(Duration duration, List<EnergyHour> energyHours) {
        energyHours.sort(Comparator.comparing(EnergyHour::getTime));
        var hoursRange = getHoursRange(duration);

        List<EnergyHour> lowestEmissionHours = new ArrayList<>();
        var lowestEmissionHoursAmount = Float.MAX_VALUE;
        for (int i = 0; i < energyHours.size(); i++) {
            if ((i + (hoursRange - 1)) < energyHours.size()) {
                var slotIndexes = getSlotIndexes(i, hoursRange);
                var slotEnergyHours = getSlotEnergyHours(slotIndexes, energyHours);
                var slotEmissionHoursAmount = getSlotEmissionHoursAmount(slotIndexes, energyHours);

                 if (lowestEmissionHoursAmount > slotEmissionHoursAmount) { 
                     lowestEmissionHours = slotEnergyHours;
                     lowestEmissionHoursAmount = slotEmissionHoursAmount;
                 }
            }
        }

        return lowestEmissionHours;
    }

    private int getHoursRange(Duration duration) {
        if (duration.toHours() == 0L) {
            return 1;
        }
        var hours = BigDecimal.valueOf(duration.toHours());
        var differenceToFullHour = BigDecimal.valueOf(duration.toMinutes())
                .remainder(hours.multiply(BigDecimal.valueOf(60)));

        return (differenceToFullHour.longValue() > 0L) ? hours.intValue() + 1 : hours.intValue();
    }

    private float getSlotEmissionHoursAmount(List<Integer> slotIndexes, List<EnergyHour> energyHours) {
        return IntStream.range(0, energyHours.size())
                .filter(slotIndexes::contains)
                .mapToObj(energyHours::get)
                .toList().stream().map(EnergyHour::getCarbonEmission).reduce(0F, Float::sum);
    }

    private List<EnergyHour> getSlotEnergyHours(List<Integer> slotIndexes, List<EnergyHour> energyHours) {
        return IntStream.range(0, energyHours.size())
                .filter(slotIndexes::contains)
                .mapToObj(energyHours::get)
                .toList();
    }

    private List<Integer> getSlotIndexes(int currentIndex, int range) {
        return Arrays.stream(IntStream.range(currentIndex, (currentIndex + range))
                .toArray())
                .boxed()
                .toList();
    }
}
