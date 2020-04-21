package ru.kpfu.itis.deadathomeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.deadathomeapi.dto.PostDto;
import ru.kpfu.itis.deadathomeapi.models.Post;
import ru.kpfu.itis.deadathomeapi.repository.PostsRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.kpfu.itis.deadathomeapi.dto.PostDto.from;
@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public List<PostDto> getPosts() {
        return from(postsRepository.findAll());
    }

    @Override
    public PostDto getConcretePost(Long postId) {
        return from(postsRepository.getOne(postId));
    }

    @Override
    public List<PostDto> search(String name) {
        return from(postsRepository.findByTitleContainsIgnoreCase(name));
    }

}
