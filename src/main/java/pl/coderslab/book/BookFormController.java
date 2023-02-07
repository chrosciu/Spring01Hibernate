package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherDao;

import java.util.List;

@Controller
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/book/new")
    public String newBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/new";
    }

    @PostMapping("/book/save")
    public String saveBook(Book book) {
        bookDao.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/list")
    public String listBooks(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "/book/list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

}
