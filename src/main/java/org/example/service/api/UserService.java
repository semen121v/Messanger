package org.example.service.api;

import org.example.model.dto.request.UserCreateDtoRequest;
import org.example.model.dto.response.UserDtoResponse;

public interface UserService {

    Long createUser(UserCreateDtoRequest dtoRequest);

    UserDtoResponse getUser(Long userId );
}
