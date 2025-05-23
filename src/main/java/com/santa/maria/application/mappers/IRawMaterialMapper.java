package com.santa.maria.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IRawMaterialMapper {
  IRawMaterialMapper INSTANCE = Mappers.getMapper(IRawMaterialMapper.class);
}
