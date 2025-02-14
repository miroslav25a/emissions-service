package com.pa.energy.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
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
    void shouldCalculateLowestEmissionFullHourRange() {
        // Given
        var hoursRange = Duration.ofHours(3);
        var resultListSize = 3;
        var energyHours = new ArrayList<>(ENERGY_HOURS);

        // When
        final var result = strategy.calculateLowestEmissionHourlyRange(hoursRange, energyHours);

        // Then
        assertThat(result).isNotNull().hasSize(resultListSize);
        assertThat(result).containsExactly(ENERGY_HOUR_7, ENERGY_HOUR_8, ENERGY_HOUR_9);
    }

    @Test
    void shouldCalculateLowestEmissionLessThanHourRange() {
        // Given
        var hoursRange = Duration.ofMinutes(30);
        var resultListSize = 1;
        var energyHours = new ArrayList<>(ENERGY_HOURS);

        // When
        final var result = strategy.calculateLowestEmissionHourlyRange(hoursRange, energyHours);

        // Then
        assertThat(result).isNotNull().hasSize(resultListSize);
        assertThat(result).containsExactly(ENERGY_HOUR_7);
    }

    @Test
    void shouldCalculateLowestEmissionMoreThanHourRange() {
        // Given
        var hoursRange = Duration.ofHours(1).plusMinutes(59);
        var resultListSize = 2;
        var energyHours = new ArrayList<>(ENERGY_HOURS);

        // When
        final var result = strategy.calculateLowestEmissionHourlyRange(hoursRange, energyHours);

        // Then
        assertThat(result).isNotNull().hasSize(resultListSize);
        assertThat(result).containsExactly(ENERGY_HOUR_7, ENERGY_HOUR_8);
    }
}