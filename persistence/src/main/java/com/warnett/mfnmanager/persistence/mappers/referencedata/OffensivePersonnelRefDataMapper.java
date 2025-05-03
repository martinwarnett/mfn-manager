package com.warnett.mfnmanager.persistence.mappers.referencedata;

import com.warnett.mfnmanager.entities.reference_data.OffensivePersonnel;
import com.warnett.mfnmanager.persistence.dbentities.OffensivePersonnelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OffensivePersonnelRefDataMapper {

    OffensivePersonnel toDTO(OffensivePersonnelEntity entity);
    OffensivePersonnelEntity toEntity(OffensivePersonnel dto);
}
