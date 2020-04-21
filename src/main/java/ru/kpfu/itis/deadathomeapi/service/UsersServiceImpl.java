package ru.kpfu.itis.deadathomeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.deadathomeapi.models.User;
import ru.kpfu.itis.deadathomeapi.dto.UserDto;
import ru.kpfu.itis.deadathomeapi.repository.UsersRepository;

import java.util.List;

import static ru.kpfu.itis.deadathomeapi.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByFirstNameOrLastNameContainsIgnoreCase(name, name));
    }
}
