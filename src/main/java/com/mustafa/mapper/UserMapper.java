package com.mustafa.mapper;

import com.mustafa.dto.request.RegisterRequestDto;
import com.mustafa.dto.response.LoginResponceDto;
import com.mustafa.dto.response.RegisterResponceDto;
import com.mustafa.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    LoginResponceDto fromUserToLoginResponceDto(final User user);

    User fromRegisterRequestDtoToUser(final RegisterRequestDto dto);

    RegisterResponceDto fromUserToRegisterResponceDto(final User user);

}
