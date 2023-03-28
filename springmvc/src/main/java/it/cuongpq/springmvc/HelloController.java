package it.cuongpq.springmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<List<String>> helloAction() {
        StudentService studentService = StudentService.getInstance();

        List<String> listStudent = studentService.getStudentList();
//        return listStudent.toString();
//        return "Spring boot hello world!";

        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @GetMapping("/string")
    public String helloJsonAction() {
        StudentService studentService = StudentService.getInstance();

        List<String> listStudent = studentService.getStudentList();
        return listStudent.toString();
    }
}
