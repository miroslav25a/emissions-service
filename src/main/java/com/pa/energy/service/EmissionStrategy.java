package com.pa.energy.service;

import com.pa.energy.domain.EnergyHour;

import java.util.List;

public interface EmissionStrategy {
    List<EnergyHour> calculateLowestEmissionHourlyRange(int hoursRange, List<EnergyHour> energyHours);
}
