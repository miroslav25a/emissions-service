package com.pa.energy.service;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.pa.energy.EnergyHourTestFixtures.ENERGY_HOURS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationHelperTest {
    private static final String ERROR_MESSAGE_DURATION = "Duration must be greater than 0";
    private static final String ERROR_MESSAGE_ENERGY_HOURS_LIST = "Energy hours list cannot be empty";
    public static final String ERROR_MESSAGE_DURATION_GREATER_THAN_ENERGY_HOURS =
            "Duration must be less than or equal to energy hours";

    @Test
    void validateArgumentsHoursRangeBelowOne() {
        // When
        assertThatThrownBy(() -> {
            ValidationHelper.validateArguments(Duration.ofMinutes(0), ENERGY_HOURS);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_DURATION);
    }

    @Test
    void validateArgumentsEnergyHoursNull() {
        // When
        assertThatThrownBy(() -> {
            ValidationHelper.validateArguments(Duration.ofHours(3), null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_ENERGY_HOURS_LIST);
    }

    @Test
    void validateArgumentsEnergyHoursLessThanDuration() {
        // When
        assertThatThrownBy(() -> {
            ValidationHelper.validateArguments(Duration.ofHours(25), ENERGY_HOURS);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_DURATION_GREATER_THAN_ENERGY_HOURS);
    }
}