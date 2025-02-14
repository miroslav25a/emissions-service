package com.pa.energy.service;

import com.pa.energy.domain.EnergyHour;
import com.pa.energy.domain.EnergyType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public interface EnergyService {
    LocalDateTime getLowestEmissionSlotTime(EnergyType type, Duration duration, List<EnergyHour> energyHours);
}
