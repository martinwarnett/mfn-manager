package com.warnett.mfnmanager.persistence.repositories.referencedata;

import com.warnett.mfnmanager.persistence.dbentities.OffensivePersonnelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffensivePersonnelRefDataRepository extends JpaRepository<OffensivePersonnelEntity, Integer> {
}
