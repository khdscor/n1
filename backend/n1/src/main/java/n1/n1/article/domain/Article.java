package n1.n1.article.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import n1.n1.user.domain.User;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false)
    private int day;

    @CreationTimestamp
    private Timestamp createdDate;

}

