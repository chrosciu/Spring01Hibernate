package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonController {
    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @ModelAttribute("languages")
    public List<String> getLanguages() {
        return List.of("java", "php", "ruby", "python");
    }

    @GetMapping("/person/add")
    public String addPersonForm(Model model) {
        Person predefinedPerson = new Person();
        predefinedPerson.setLogin("chrosciu");
        model.addAttribute("person", predefinedPerson);
        return "/person/add";
    }

    @PostMapping("/person/add")
    @ResponseBody
    public String addPerson(Person person) {
        personDao.save(person);
        return person.toString();
    }

}
