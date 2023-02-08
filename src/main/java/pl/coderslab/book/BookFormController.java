package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherDao;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookFormController {
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;

    public BookFormController(PublisherDao publisherDao, BookRepository bookRepository) {
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book/new")
    public String newBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/new";
    }

    @PostMapping("/book/save")
    public String saveBook(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/book/new";
        }
        bookRepository.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/list")
    public String listBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "/book/list";
    }

    @GetMapping("/book/edit/{id}")
    public String editBook(Model model) {
        //fetch book by id
        //pass book to model
        //return view
        return null;
    }

    @PostMapping("/book/update")
    public String updateBook(Book book) {
        //update book
        return "redirect:/book/list";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBookForm(Model model) {
        //pass id to model
        //display form with OK and Cancel
        //Cancel - link to book list
        //OK - post to delete action
        return null;
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook() {
        //find book by id
        //delete book
        return "redirect:/book/list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

}
