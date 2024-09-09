package com.backend.gestion_eventos.services;

import com.backend.gestion_eventos.models.Comment;
import com.backend.gestion_eventos.models.User;
import com.backend.gestion_eventos.repositories.CommentRepository;
import com.backend.gestion_eventos.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Transactional
    public Comment saveComment(Comment comment) {
        User user = userRepository.findById(comment.getUser().getId()).orElseThrow();
        Comment newComment = Comment.builder()
                .text(comment.getText())
                .date(LocalDateTime.now())
                .user(user)
                .build();
        return commentRepository.save(newComment);
    }

    @Transactional
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    public Comment updateComment(Integer id, Comment comment) {
        Comment commentToUpdate = commentRepository.findById(id).orElseThrow();
        commentToUpdate.setText(comment.getText());
        return commentRepository.save(commentToUpdate);
    }

    public Comment getComment(Integer id) {
        return commentRepository.findById(id).orElseThrow();
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
