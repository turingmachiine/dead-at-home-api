package ru.kpfu.itis.deadathomeapi.service;

import ru.kpfu.itis.deadathomeapi.dto.PostDto;
import ru.kpfu.itis.deadathomeapi.models.House;
import ru.kpfu.itis.deadathomeapi.models.Post;

import java.util.List;

public interface PostsService {
    List<PostDto> getPosts();

    PostDto getConcretePost(Long postId);

    List<PostDto> search(String name);

}
