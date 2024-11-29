package com.example.food_delivery.mapper;

import com.example.food_delivery.dto.FeedBackCreateDto;
import com.example.food_delivery.dto.FeedBackDto;
import com.example.food_delivery.dto.authuser.AuthUserDto;
import com.example.food_delivery.entity.AuthUser;
import com.example.food_delivery.entity.FeedBack;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T12:19:08+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FeedBackMapperImpl implements FeedBackMapper {

    @Override
    public FeedBackDto toDto(FeedBack feedback) {
        if ( feedback == null ) {
            return null;
        }

        FeedBackDto feedBackDto = new FeedBackDto();

        feedBackDto.setId( feedback.getId() );
        feedBackDto.setAuthUser( authUserToAuthUserDto( feedback.getAuthUser() ) );
        feedBackDto.setMessage( feedback.getMessage() );
        feedBackDto.setSendAt( feedback.getSendAt() );

        return feedBackDto;
    }

    @Override
    public List<FeedBackDto> toDto(List<FeedBack> feedBacks) {
        if ( feedBacks == null ) {
            return null;
        }

        List<FeedBackDto> list = new ArrayList<FeedBackDto>( feedBacks.size() );
        for ( FeedBack feedBack : feedBacks ) {
            list.add( toDto( feedBack ) );
        }

        return list;
    }

    @Override
    public FeedBack toEntity(FeedBackCreateDto feedbackCreateDto) {
        if ( feedbackCreateDto == null ) {
            return null;
        }

        FeedBack feedBack = new FeedBack();

        feedBack.setMessage( feedbackCreateDto.message() );

        return feedBack;
    }

    protected AuthUserDto authUserToAuthUserDto(AuthUser authUser) {
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
