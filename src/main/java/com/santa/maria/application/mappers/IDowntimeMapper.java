package com.santa.maria.application.mappers;

import com.santa.maria.application.responses.DowntimeResponse;
import com.santa.maria.domain.entities.Downtime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IDowntimeMapper {
  IDowntimeMapper INSTANCE = Mappers.getMapper(IDowntimeMapper.class);

  DowntimeResponse mapToResponse(Downtime downtime);
}
