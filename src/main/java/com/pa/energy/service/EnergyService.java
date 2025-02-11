package com.pa.energy.service;

import com.pa.energy.domain.EnergyHour;
import com.pa.energy.domain.EnergyType;

import java.util.List;

public interface EnergyService {
    List<EnergyHour> getLowestEmissionSlot(EnergyType type, int hoursRange, List<EnergyHour> energyHours);
}
