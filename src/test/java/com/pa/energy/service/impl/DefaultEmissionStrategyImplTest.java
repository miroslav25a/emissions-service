package com.pa.energy.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.pa.energy.EnergyHourTestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class DefaultEmissionStrategyImplTest {
    private DefaultEmissionStrategyImpl strategy;

    @BeforeEach
    void setUp() {
        strategy = new DefaultEmissionStrategyImpl();
    }

    @Test
    void shouldCalculateLowestEmissionThreeHoursRange() {
        // Given
        var hoursRange = 3;
        var energyHours = new ArrayList<>(ENERGY_HOURS);

        // When
        final var result = strategy.calculateLowestEmissionHourlyRange(hoursRange, energyHours);

        // Then
        assertThat(result).isNotNull().hasSize(hoursRange);
        assertThat(result).containsExactly(ENERGY_HOUR_7, ENERGY_HOUR_8, ENERGY_HOUR_9);
    }
}