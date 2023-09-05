package pro.sky.hogwartsdb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogwartsdb.model.Student;
import pro.sky.hogwartsdb.service.StudentService;
import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createStudent);
    }

    @GetMapping("{Id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long Id) {
        Student student = studentService.findStudent(Id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent (student);
        if (updateStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent (@PathVariable Long id) {
        studentService.deleteStudent(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("All")
    public Collection<Student> findAllStudent() {
        return studentService.findAllStudent() ;
    }

    @GetMapping()
    public Collection<Student> findAllByAgeStudent(@RequestParam int age) {
        return studentService.findAllByAge(age) ;
    }

    @GetMapping("age")
    public ResponseEntity<Collection<Student>> findByAgeBetween(@RequestParam int age1, @RequestParam int age2, @RequestParam String namePart) {
        if (age1 > 0 && age2 > age1) {
            return ResponseEntity.ok(studentService.findByAgeBetween(age1, age2));
        }
        if (namePart != null && !namePart.isBlank()) {
            return ResponseEntity.ok(studentService.findAllByNameContains(namePart));
        }
        return ResponseEntity.ok(studentService.findAllStudent());
    }
}