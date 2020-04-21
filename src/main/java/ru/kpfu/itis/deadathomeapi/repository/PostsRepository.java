package ru.kpfu.itis.deadathomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.deadathomeapi.models.House;
import ru.kpfu.itis.deadathomeapi.models.Post;
import ru.kpfu.itis.deadathomeapi.models.User;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Post, Long>{
    Optional<Post> findByTitleIgnoreCase(String title);
    List<Post> findByAuthor(User author);
    List<Post> findByHouse(House house);
    List<Post> findByHouseAndIdIsNot(House house, Long id);
    List<Post> findByTitleContainsIgnoreCase(String name);
}
