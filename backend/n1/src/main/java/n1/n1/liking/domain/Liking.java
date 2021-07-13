package n1.n1.liking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import n1.n1.article.domain.Article;
import n1.n1.user.domain.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Liking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="liking_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;

}

