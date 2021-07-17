package n1.n1.comment.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import javax.transaction.Transactional;
import n1.n1.article.domain.Article;
import n1.n1.article.domain.Date;
import n1.n1.article.repository.ArticleRepository;
import n1.n1.comment.domain.Comment;
import n1.n1.comment.dto.CommentResponse;
import n1.n1.comment.repository.CommentRepository;
import n1.n1.user.domain.User;
import n1.n1.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class CommentServiceTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentService commentService;

    private User savedUser;

    @BeforeEach
    void setup(){
        User user= User.builder()
            .nickName("khds")
            .password("12345")
            .email("khds@naver.com")
            .build();

        savedUser = userRepository.save(user);
    }

    @Test
    void findCommentsByArticleId(){
        //given
        Article article = Article.builder()
            .user(savedUser)
            .title("제목!")
            .content("내용!")
            .date(new Date(2012,6,21))
            .build();

        articleRepository.save(article);

        Comment comment = Comment.builder()
            .user(savedUser)
            .article(article)
            .content("이것은 댓글내용!")
            .build();
        commentRepository.save(comment);

        //when
        List<CommentResponse> comments = commentService.findCommentsByArticleId(article.getId());

        //then
        assertThat(comments).isNotNull();
        assertThat(comments.size()).isEqualTo(1);
        assertThat(comment.getId()).isEqualTo(comment.getId());
        assertThat(comment.getArticle().getId()).isEqualTo(article.getId());
        assertThat(comment.getUser().getId()).isEqualTo(savedUser.getId());
        assertThat(comment.getContent()).isNotEmpty();

    }
}