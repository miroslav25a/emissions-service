package com.pa.energy.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class EnergyHour {
    LocalDateTime time;
    float carbonEmission;
}
