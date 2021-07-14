package n1.n1.article.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Date {

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false)
    private int day;
}
