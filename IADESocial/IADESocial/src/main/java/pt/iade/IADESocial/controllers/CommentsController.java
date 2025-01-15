package pt.iade.IADESocial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.IADESocial.models.Comments;
import pt.iade.IADESocial.models.repositories.CommentsRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/comments")
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;

    // Endpoint para pegar todos os comentários relacionados a um post específico
    @GetMapping(path = "/post/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comments> getCommentsByPostId(@PathVariable int postId) {
        return commentsRepository.findByPostId(postId);  // Retorna todos os comentários para o PostID fornecido
    }

    // Endpoint para criar um novo comentário
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comments createComment(@RequestBody Comments newComment) {
        if (newComment.getPostId() <= 0 || newComment.getProfileId() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PostID and ProfileID must be valid numbers");
        }
        return commentsRepository.save(newComment);  // Salva o novo comentário no banco de dados
    }
}
