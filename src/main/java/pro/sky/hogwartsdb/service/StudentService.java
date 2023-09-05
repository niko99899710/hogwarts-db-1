package pro.sky.hogwartsdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.hogwartsdb.model.Student;
import pro.sky.hogwartsdb.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StudentService {
   private final StudentRepository studentRepository;

   @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long Id) {
        return studentRepository.getById(Id);

    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Collection<Student> findAge (int age) {
       return studentRepository.findAll();
    }


}
