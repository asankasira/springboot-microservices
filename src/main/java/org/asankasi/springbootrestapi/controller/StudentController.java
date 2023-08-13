package org.asankasi.springbootrestapi.controller;

import org.asankasi.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        var st = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );
        return ResponseEntity.ok(st);
    }

    @GetMapping
    public List<Student> getStudents() {
        var st = new Student(1);
        st.setFirstName("Shanka");
        st.setLastName("Ranthunga");
        return Collections.singletonList(st);
    }

    //http://localhost:8080/students/2/ABC/Perera
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student getStudentPathVariable(@PathVariable int id,
                                          @PathVariable("first-name") String firstName,
                                          @PathVariable("last-name") String lastName) {
        var st = new Student(id);
        st.setLastName(lastName);
        st.setFirstName(firstName);
        return st;
    }

    //http://localhost:8080/students/query?id=3&firstName=Nimal
    @GetMapping("query")
    public ResponseEntity<Student> getStudentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName) {
        var st = new Student(id);
        st.setFirstName(firstName);
        return ResponseEntity.ok().header("q-header", "queried").body(st);
    }

    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("{name}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable String name) {
        student.setFirstName(name);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping(value = "{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        return "Successfully Deleted student with id: " + studentId;
    }
}
