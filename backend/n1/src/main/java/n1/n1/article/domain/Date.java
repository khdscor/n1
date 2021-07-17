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

    public Date(){}
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
