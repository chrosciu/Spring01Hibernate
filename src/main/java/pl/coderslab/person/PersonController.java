package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/person/add")
    public String addPersonForm() {
        return "/person/add";
    }

    @PostMapping("/person/add")
    @ResponseBody
    public String addPerson(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String email) {
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personDao.save(person);
        return person.toString();
    }

}
