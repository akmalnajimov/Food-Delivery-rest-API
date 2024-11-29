package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.authuser.AuthUserCreateDto;
import com.example.food_delivery.dto.authuser.AuthUserDto;
import com.example.food_delivery.dto.authuser.AuthUserUpdateDto;
import com.example.food_delivery.entity.AuthUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T12:19:08+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AuthUserMapperImpl implements AuthUserMapper {

    @Override
    public AuthUser toEntity(AuthUserCreateDto authUserCreateDto) {
        if ( authUserCreateDto == null ) {
            return null;
        }

        AuthUser authUser = new AuthUser();

        authUser.setName( authUserCreateDto.name() );
        authUser.setEmail( authUserCreateDto.email() );
        authUser.setPassword( authUserCreateDto.password() );
        authUser.setPhoneNumber( authUserCreateDto.phoneNumber() );

        return authUser;
    }

    @Override
    public AuthUser partialUpdate(AuthUserUpdateDto authUserUpdateDto, AuthUser authUser) {
        if ( authUserUpdateDto == null ) {
            return authUser;
        }

        if ( authUserUpdateDto.name() != null ) {
            authUser.setName( authUserUpdateDto.name() );
        }
        if ( authUserUpdateDto.email() != null ) {
            authUser.setEmail( authUserUpdateDto.email() );
        }
        if ( authUserUpdateDto.password() != null ) {
            authUser.setPassword( authUserUpdateDto.password() );
        }
        if ( authUserUpdateDto.phoneNumber() != null ) {
            authUser.setPhoneNumber( authUserUpdateDto.phoneNumber() );
        }

        return authUser;
    }

    @Override
    public AuthUserDto toDto(AuthUser authUser) {
        if ( authUser == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String phoneNumber = null;

        name = authUser.getName();
        email = authUser.getEmail();
        phoneNumber = authUser.getPhoneNumber();

        AuthUserDto authUserDto = new AuthUserDto( name, email, phoneNumber );

        return authUserDto;
    }
}
