
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.print.Book;

@Setter
@Getter
@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer pageNo;
    private String chapterNo;

    @Column(name = "book_id")
    private Long bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;


    public Page() {
    }
}
