package com.courier.errorservice.objects.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.courier.errorservice.objects.dto.ErrorLogDto;
import com.courier.errorservice.objects.entity.ErrorLog;

@Mapper(componentModel = "spring")
public interface ErrorLogMapper {

  @Mapping(target = "id", ignore = true)
  ErrorLog toEntity(ErrorLogDto errorLogDto);
}
