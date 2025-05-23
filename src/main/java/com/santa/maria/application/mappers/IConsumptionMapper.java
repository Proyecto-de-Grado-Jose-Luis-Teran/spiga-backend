package com.santa.maria.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IConsumptionMapper {
  IConsumptionMapper INSTANCE = Mappers.getMapper(IConsumptionMapper.class);
}
