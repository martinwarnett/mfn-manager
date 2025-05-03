package com.warnett.mfnmanager.persistence.repositories;

import com.warnett.mfnmanager.persistence.dbentities.OffensivePersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffensivePersonnelRefDataRepository extends JpaRepository<OffensivePersonnel, Integer> {
}
