package com.pa.energy.service.impl;

import com.pa.energy.EnergyHourTestFixtures;
import com.pa.energy.domain.EnergyType;
import com.pa.energy.service.EmissionStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.pa.energy.EnergyHourTestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.pa.energy.domain.EnergyType.SLOT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EnergyServiceImplTest {
    @Mock
    private EmissionStrategy emissionStrategy;

    @InjectMocks
    private EnergyServiceImpl service;

    @Test
    void shouldGetLowestEmissionSlot() {
        // Given
        var hoursRange = 3;
        var resultEnergyHours = List.of(ENERGY_HOUR_7, ENERGY_HOUR_8, ENERGY_HOUR_9);
        given(emissionStrategy.calculateLowestEmissionHourlyRange(hoursRange, ENERGY_HOURS))
                .willReturn(resultEnergyHours);

        // When
        final var result = service.getLowestEmissionSlot(SLOT, hoursRange, ENERGY_HOURS);

        // Then
        assertThat(result).isNotNull().hasSize(3);
        assertThat(result).containsExactly(ENERGY_HOUR_7, ENERGY_HOUR_8, ENERGY_HOUR_9);
        verify(emissionStrategy, times(1)).calculateLowestEmissionHourlyRange(hoursRange, ENERGY_HOURS);
    }
}