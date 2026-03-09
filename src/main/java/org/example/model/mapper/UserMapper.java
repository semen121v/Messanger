package org.example.model.mapper;

import org.example.model.dto.request.UserCreateDtoRequest;
import org.example.model.dto.response.UserDtoResponse;
import org.example.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserCreateDtoRequest dto);

    UserDtoResponse toModel(UserEntity entity);
}
