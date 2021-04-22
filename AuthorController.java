import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable("id") Long id) {
        return authorRepository.findById(id).get();
    }

    @PostMapping("")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id,
                               @RequestBody Author author) {
        author.setId((id));
        return authorRepository.saveAndFlush(author);
    }

    @PatchMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id,
                           @RequestParam Integer Year) {
        Author author = authorRepository.findById(id).get();
        Author.setYear(Year);
        return authorRepository.saveAndFlush(author);
    }
}
