package com.example.controller;

import com.example.model.Lesson;
import com.example.model.Teacher;
import com.example.model.TeacherLesson;
import com.example.model.User;
import com.example.service.Impl.UserServiceImpl;

import com.example.service.LessonService;
import com.example.service.TeacherLessonService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@Controller//("/Login")
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private TeacherLessonService teacherLessonService;

    @GetMapping("/login")
    public String Login() {
        return "index";
    }

    @PostMapping("/login")
    public String log(@RequestParam String login, @RequestParam String password){
        if (userService.doLog(login, password)) {
            if(Objects.equals(userService.findRoleByLogin(login), "admin")){
                return "redirect:/getUser";
            }else {
                return "redirect:/UnList";
            }
        } else {
            return register();
        }
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String reg(@RequestParam String login, @RequestParam String password, @RequestParam String email){
        if (!userService.testLoginAndEmail(login, email)){
            userService.addUser(login, password, email);
            return welcome();
        }else{
            return "anewRegister";
        }
    }


    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }


    @GetMapping("/getUser")
    public String getUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList"; // Вернуть имя представления, которое нужно отобразить
    }
    @GetMapping("/UnList")
    public String unList(Model model){
        List<TeacherLesson> teacherLessons = teacherLessonService.getAllTeacherLesson();
        model.addAttribute("teacherLessons", teacherLessons);
        return "unList";
    }

}
