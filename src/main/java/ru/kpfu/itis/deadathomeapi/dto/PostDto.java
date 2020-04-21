package ru.kpfu.itis.deadathomeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.deadathomeapi.models.House;
import ru.kpfu.itis.deadathomeapi.models.Post;
import ru.kpfu.itis.deadathomeapi.models.User;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String postText;
    private LocalDateTime createdAt;
    private HousesDto house;
    private UserDto author;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .postText(post.getPostText())
                .createdAt(post.getCreatedAt())
                .author(UserDto.from(post.getAuthor()))
                .house(HousesDto.from(post.getHouse()))
                .build();
    }

    public static List<PostDto> from(List<Post> posts) {
        return posts.stream().map(PostDto::from).collect(Collectors.toList());
    }

}
