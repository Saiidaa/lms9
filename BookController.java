
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        book.setId((long) Math.toIntExact(id));
        return bookRepository.saveAndFlush(book);
    }

    @PatchMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestParam Integer nom) {
        Book book = bookRepository.findById(id).get();
        book.setPages(nom);
        
        return bookRepository.saveAndFlush(book);
    }

}
