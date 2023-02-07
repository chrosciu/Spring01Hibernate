package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    @GetMapping("/student/new")
    public String newStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "/student/new";
    }

    @PostMapping("/student/new")
    @ResponseBody
    public String createStudent(Student student) {
        return student.toString();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "Czechia", "Slovakia");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Groovy", "Kotlin", "Scala");
    }

}
