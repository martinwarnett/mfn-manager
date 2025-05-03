package com.warnett.mfnmanager.persistence.dbentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="offensive_personnel", schema="reference_data")
public record OffensivePersonnel(
    @Id
    @Column(name="id")
    Integer id,

    @Column(name = "display_name")
    String displayName,

    @Column(name = "description")
    String description,

    @Column(name="option_number")
    Integer optionNumber,

    @Column(name="creation_date")
    LocalDateTime creationDate,

    @Column(name="last_updated_date")
    LocalDateTime lastUpdatedDate) {

    // Empty constructor required by JPA
    public OffensivePersonnel() {
        this(null,null, null, null, null, null);
    }
}
