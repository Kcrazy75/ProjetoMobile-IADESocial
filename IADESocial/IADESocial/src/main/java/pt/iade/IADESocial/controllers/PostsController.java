package pt.iade.IADESocial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.IADESocial.models.Posts;
import pt.iade.IADESocial.models.repositories.PostsRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
public class PostsController {

    @Autowired
    private PostsRepository postRepository;

    // Endpoint para criar um novo post
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Posts createPost(@RequestBody Posts newPost) {
        // Verifica se o ProfileID existe. Adicione a lógica de verificação se necessário.
        if (newPost.getProfileId() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ProfileID must be a valid number");
        }

        return postRepository.save(newPost);  // Salva o novo post no banco de dados
    }

    // Endpoint para pegar todos os posts
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Posts> getAllPosts() {
        return (List<Posts>) postRepository.findAll();  // Retorna todos os posts no banco de dados
    }

    @GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Posts> getPostsByUserId(@PathVariable int userId) {
        // Verifica se o userId é válido
        if (userId <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User ID must be a valid number");
        }

        // Retorna os posts do usuário com o perfilId fornecido
        List<Posts> posts = postRepository.findByProfileId(userId);

        if (posts.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No posts found for the given userId");
        }

        return posts;
    }

}
