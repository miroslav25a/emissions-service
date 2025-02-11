package com.pa.energy;

import com.pa.energy.domain.EnergyHour;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public enum EnergyHourTestFixtures {;
    public static final EnergyHour ENERGY_HOUR_0 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 0, 0))
            .carbonEmission(50F)
            .build();
    public static final EnergyHour ENERGY_HOUR_1 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 1, 0))
            .carbonEmission(50F)
            .build();
    public static final EnergyHour ENERGY_HOUR_2 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 2, 0))
            .carbonEmission(200F)
            .build();
    public static final EnergyHour ENERGY_HOUR_3 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 3, 0))
            .carbonEmission(300F)
            .build();
    public static final EnergyHour ENERGY_HOUR_4 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 4, 0))
            .carbonEmission(21F)
            .build();
    public static final EnergyHour ENERGY_HOUR_5 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 5, 0))
            .carbonEmission(1000F)
            .build();
    public static final EnergyHour ENERGY_HOUR_6 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 6, 0))
            .carbonEmission(2000F)
            .build();
    public static final EnergyHour ENERGY_HOUR_7 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 7, 0))
            .carbonEmission(10F)
            .build();
    public static final EnergyHour ENERGY_HOUR_8 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 8, 0))
            .carbonEmission(11F)
            .build();
    public static final EnergyHour ENERGY_HOUR_9 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 9, 0))
            .carbonEmission(12F)
            .build();
    public static final EnergyHour ENERGY_HOUR_10 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 10, 0))
            .carbonEmission(10F)
            .build();
    public static final EnergyHour ENERGY_HOUR_11 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 11, 0))
            .carbonEmission(11F)
            .build();
    public static final EnergyHour ENERGY_HOUR_12 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 12, 0))
            .carbonEmission(13F)
            .build();
    public static final EnergyHour ENERGY_HOUR_13 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 13, 0))
            .carbonEmission(22F)
            .build();
    public static final EnergyHour ENERGY_HOUR_14 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 14, 0))
            .carbonEmission(55F)
            .build();
    public static final EnergyHour ENERGY_HOUR_15 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 15, 0))
            .carbonEmission(301F)
            .build();
    public static final EnergyHour ENERGY_HOUR_16 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 16, 0))
            .carbonEmission(3011F)
            .build();
    public static final EnergyHour ENERGY_HOUR_17 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 17, 0))
            .carbonEmission(2011F)
            .build();
    public static final EnergyHour ENERGY_HOUR_18 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 18, 0))
            .carbonEmission(1011F)
            .build();
    public static final EnergyHour ENERGY_HOUR_19 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 19, 0))
            .carbonEmission(1015F)
            .build();
    public static final EnergyHour ENERGY_HOUR_20 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 20, 0))
            .carbonEmission(555F)
            .build();
    public static final EnergyHour ENERGY_HOUR_21 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 21, 0))
            .carbonEmission(87F)
            .build();
    public static final EnergyHour ENERGY_HOUR_22 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 22, 0))
            .carbonEmission(99F)
            .build();
    public static final EnergyHour ENERGY_HOUR_23 = EnergyHour.builder()
            .time(LocalDateTime.of(2025, 2, 10, 23, 0))
            .carbonEmission(74F)
            .build();

    public static final List<EnergyHour> ENERGY_HOURS = List.of(
            ENERGY_HOUR_0,
            ENERGY_HOUR_1,
            ENERGY_HOUR_2,
            ENERGY_HOUR_3,
            ENERGY_HOUR_4,
            ENERGY_HOUR_5,
            ENERGY_HOUR_6,
            ENERGY_HOUR_7,
            ENERGY_HOUR_8,
            ENERGY_HOUR_9,
            ENERGY_HOUR_10,
            ENERGY_HOUR_11,
            ENERGY_HOUR_12,
            ENERGY_HOUR_13,
            ENERGY_HOUR_14,
            ENERGY_HOUR_15,
            ENERGY_HOUR_16,
            ENERGY_HOUR_17,
            ENERGY_HOUR_18,
            ENERGY_HOUR_19,
            ENERGY_HOUR_20,
            ENERGY_HOUR_21,
            ENERGY_HOUR_22,
            ENERGY_HOUR_23
    );
}
