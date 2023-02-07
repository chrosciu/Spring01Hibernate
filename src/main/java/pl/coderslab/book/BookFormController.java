package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/book/form/new")
    public String saveBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/new";
    }

    @PostMapping("/book/form/save")
    @ResponseBody
    public String saveBookForm(Book book) {
        bookDao.save(book);
        return book.toString();
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

}
