package com.warnett.mfnmanager.entities.reference_data;

import java.time.LocalDateTime;

public record OffensivePersonnel(int id,
                                 String displayName,
                                 String description,
                                 int optionNumber,
                                 LocalDateTime creationDate,
                                 LocalDateTime lastUpdatedDate) { }
