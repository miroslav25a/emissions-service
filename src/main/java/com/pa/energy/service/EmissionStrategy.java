package com.pa.energy.service;

import com.pa.energy.domain.EnergyHour;

import java.time.Duration;
import java.util.List;

public interface EmissionStrategy {
    List<EnergyHour> calculateLowestEmissionHourlyRange(Duration duration, List<EnergyHour> energyHours);
}
