package n1.n1.comment.dto;

import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import n1.n1.user.dto.AuthorResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class CommentResponse {

    private Long id;
    private String content;
    private AuthorResponse author;
    private Timestamp createDate;
}
