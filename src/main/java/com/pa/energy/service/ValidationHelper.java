package com.pa.energy.service;

import com.pa.energy.domain.EnergyHour;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

public enum ValidationHelper {;
    public static final String ERROR_MESSAGE_HOURS_RANGE = "Hours range must be greater than 0";
    public static final String ERROR_MESSAGE_ENERGY_HOURS_LIST = "Energy hours list cannot be empty";

    public static void validateArguments(int hoursRange, List<EnergyHour> energyHours) {
        if (hoursRange < 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HOURS_RANGE);
        }

        if (isEmpty(energyHours)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ENERGY_HOURS_LIST);
        }
    }
}
