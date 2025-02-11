package com.pa.energy.service.impl;

import com.pa.energy.domain.EnergyHour;
import com.pa.energy.domain.EnergyType;
import com.pa.energy.exception.EnergyTypeException;
import com.pa.energy.service.EmissionStrategy;
import com.pa.energy.service.EnergyService;
import com.pa.energy.service.ValidationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pa.energy.service.ValidationHelper.validateArguments;
import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class EnergyServiceImpl implements EnergyService {
    private final EmissionStrategy defaultEmissionStrategy;

    @Override
    public  List<EnergyHour> getLowestEmissionSlot(EnergyType type, int hoursRange, List<EnergyHour> energyHours) {
        validateArguments(hoursRange, energyHours);

        // this switch can be replaced by an IF statement, because at the moment there is only one type.
        // it was left as a switch to accommodate multiple types in the future.
        return switch (type) {
            case SLOT -> defaultEmissionStrategy.calculateLowestEmissionHourlyRange(hoursRange, energyHours);
            default   -> throw new EnergyTypeException(format("Unknown energy type: %s", type));
        };
    }
}
