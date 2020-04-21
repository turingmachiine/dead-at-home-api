package ru.kpfu.itis.deadathomeapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.deadathomeapi.dto.HousesDto;
import ru.kpfu.itis.deadathomeapi.dto.PostDto;
import ru.kpfu.itis.deadathomeapi.dto.UserDto;
import ru.kpfu.itis.deadathomeapi.models.House;
import ru.kpfu.itis.deadathomeapi.models.Post;
import ru.kpfu.itis.deadathomeapi.service.HousesService;
import ru.kpfu.itis.deadathomeapi.service.PostsService;
import ru.kpfu.itis.deadathomeapi.service.UsersService;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class CoursesController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private HousesService housesService;

    @Autowired
    private PostsService postsService;

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam(value = "id", required = false)Long id, @RequestParam(value = "name", required = false) String name) {
        log.info("Get users request");
        if (id != null) {
            return Arrays.asList(usersService.getConcreteUser(id));
        } else if (name != null) {
            return usersService.search(name);
        } else {
            return usersService.getUsers();
        }
    }

    @GetMapping("/houses")
    public List<HousesDto> getHouses(@RequestParam(value = "id", required = false)Long id, @RequestParam(value = "name", required = false) String name) {
        log.info("Get users request");
        if (id != null) {
            return Arrays.asList(housesService.getConcreteHouse(id));
        } else if (name != null) {
            return housesService.search(name);
        } else {
            return housesService.getHouses();
        }
    }

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(value = "id", required = false)Long id, @RequestParam(value = "name", required = false) String name) {
        log.info("Get users request");
        if (id != null) {
            return Arrays.asList(postsService.getConcretePost(id));
        } else if (name != null) {
            return postsService.search(name);
        } else {
            return postsService.getPosts();
        }
    }

}
