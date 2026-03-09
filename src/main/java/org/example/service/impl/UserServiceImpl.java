package org.example.service.impl;

import org.example.model.dto.request.UserCreateDtoRequest;
import org.example.model.dto.response.UserDtoResponse;
import org.example.model.entity.UserEntity;
import org.example.model.mapper.UserMapper;
import org.example.repository.UserRepository;
import org.example.service.api.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Long createUser(UserCreateDtoRequest dtoRequest) {
        var entity = mapper.toEntity(dtoRequest);

        entity = userRepository.saveAndFlush(entity);

        return entity.getId();
    }

    @Override
    public UserDtoResponse getUser(Long userId) {
        Optional<UserEntity> userOpt = userRepository.findById(userId);

        return userOpt.map(mapper::toModel).orElse(null);
    }
}
