package com.pa.energy.service.impl;

import com.pa.energy.service.EmissionStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.pa.energy.EnergyHourTestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.time.Duration;
import java.util.List;

import static com.pa.energy.domain.EnergyType.SLOT;
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
        var duration = Duration.ofHours(3);
        var resultEnergyHours = List.of(ENERGY_HOUR_7, ENERGY_HOUR_8, ENERGY_HOUR_9);
        given(emissionStrategy.calculateLowestEmissionHourlyRange(duration, ENERGY_HOURS))
                .willReturn(resultEnergyHours);

        // When
        final var result = service.getLowestEmissionSlotTime(SLOT, duration, ENERGY_HOURS);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(ENERGY_HOUR_7.getTime());
        verify(emissionStrategy, times(1)).calculateLowestEmissionHourlyRange(duration, ENERGY_HOURS);
    }
}