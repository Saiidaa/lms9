import lombok.Getter;
import lombok.Setter;
import sun.jvm.hotspot.debugger.Page;

import javax.persistence.*;
import java.util.Set;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Page> pages;
    private Set<Author> users;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

}

