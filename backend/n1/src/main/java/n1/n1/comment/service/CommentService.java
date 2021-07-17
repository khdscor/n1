package n1.n1.comment.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import n1.n1.user.dto.AuthorResponse;
import n1.n1.comment.dto.CommentResponse;
import n1.n1.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public List<CommentResponse> findCommentsByArticleId(Long articleId) {

        return commentRepository.findAllByArticleId(articleId).stream()
            .map((comment -> new CommentResponse(
                comment.getId(),
                comment.getContent(),
                new AuthorResponse(
                    comment.getUser().getId(),
                    comment.getUser().getNickName()),
                comment.getCreatedDate())))
            .collect(Collectors.toList());
    }
}
