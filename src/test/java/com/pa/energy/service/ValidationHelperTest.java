package com.pa.energy.service;

import org.junit.jupiter.api.Test;

import static com.pa.energy.EnergyHourTestFixtures.ENERGY_HOURS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationHelperTest {
    private static final String ERROR_MESSAGE_HOURS_RANGE = "Hours range must be greater than 0";
    private static final String ERROR_MESSAGE_ENERGY_HOURS_LIST = "Energy hours list cannot be empty";

    @Test
    void validateArgumentsHoursRangeBelowOne() {
        // When
        assertThatThrownBy(() -> {
            ValidationHelper.validateArguments(0, ENERGY_HOURS);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HOURS_RANGE);
    }

    @Test
    void validateArgumentsEnergyHoursNull() {
        // When
        assertThatThrownBy(() -> {
            ValidationHelper.validateArguments(3, null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_ENERGY_HOURS_LIST);
    }
}