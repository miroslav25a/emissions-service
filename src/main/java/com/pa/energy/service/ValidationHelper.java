package com.pa.energy.service;

import com.pa.energy.domain.EnergyHour;

import java.time.Duration;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

public enum ValidationHelper {;
    public static final String ERROR_MESSAGE_DURATION = "Duration must be greater than 0";
    public static final String ERROR_MESSAGE_ENERGY_HOURS_LIST = "Energy hours list cannot be empty";
    public static final String ERROR_MESSAGE_DURATION_GREATER_THAN_ENERGY_HOURS =
            "Duration must be less than or equal to energy hours";

    public static void validateArguments(Duration duration, List<EnergyHour> energyHours) {
        if (duration.toMinutes() < 1L) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DURATION);
        }

        if (isEmpty(energyHours)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ENERGY_HOURS_LIST);
        }

        if (duration.toMinutes() > Duration.ofHours(energyHours.size()).toMinutes()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DURATION_GREATER_THAN_ENERGY_HOURS);
        }
    }
}
