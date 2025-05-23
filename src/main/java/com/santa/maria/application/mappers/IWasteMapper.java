package com.santa.maria.application.mappers;

import com.santa.maria.application.responses.WasteResponse;
import com.santa.maria.domain.entities.Production;
import com.santa.maria.domain.entities.Waste;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface IWasteMapper {
  IWasteMapper INSTANCE = Mappers.getMapper(IWasteMapper.class);

  @Mapping(
          target = "productionId",
          source = "production",
          qualifiedByName = "productionToId"
  )
  WasteResponse mapToResponse(Waste waste);

  @Named("productionToId")
  static UUID productionToId(Production production) {
    return production != null ? production.getProductionId() : null;
  }
}
