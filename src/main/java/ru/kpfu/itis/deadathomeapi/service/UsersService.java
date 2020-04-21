package ru.kpfu.itis.deadathomeapi.service;

import ru.kpfu.itis.deadathomeapi.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    UserDto getConcreteUser(Long userId);

    List<UserDto> search(String name);
}
