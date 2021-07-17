package n1.n1.comment.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import n1.n1.comment.dto.CommentResponse;
import n1.n1.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CommentResponse>> findCommentsByArticleId(
        @RequestParam(value = "article_id") Long articleId){

        List<CommentResponse> comments= commentService.findCommentsByArticleId(articleId);

        return ResponseEntity.ok().body(comments);
    }

}
