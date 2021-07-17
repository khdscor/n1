package n1.n1.comment.repository;

import java.util.List;
import n1.n1.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment>findAllByArticleId(Long articleId);

}
