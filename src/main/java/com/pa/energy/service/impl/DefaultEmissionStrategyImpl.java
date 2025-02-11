package com.pa.energy.service.impl;

import com.pa.energy.domain.EnergyHour;
import com.pa.energy.service.EmissionStrategy;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component("defaultEmissionStrategy")
public class DefaultEmissionStrategyImpl implements EmissionStrategy {

    @Override
    public List<EnergyHour> calculateLowestEmissionHourlyRange(int hoursRange, List<EnergyHour> energyHours) {
        energyHours.sort(Comparator.comparing(EnergyHour::getTime));

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
