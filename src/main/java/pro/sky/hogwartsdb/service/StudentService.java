package pro.sky.hogwartsdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.hogwartsdb.model.Faculty;
import pro.sky.hogwartsdb.model.Student;
import pro.sky.hogwartsdb.repository.StudentRepository;
import java.util.Collection;

@Service
public class StudentService {
   private final StudentRepository studentRepository;

  // @Autowired
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

    public Collection<Student> findAllByAge (int age) {
    return studentRepository.findAllByAge(age);
    }

    public Collection <Student> findByAgeBetween (int age1, int age2) {
       return studentRepository.findByAgeBetween(age1, age2);
    }

    public Collection <Student> findAllByNameContains (String part){
       return studentRepository.findAllByNameContains(part);
    }

    public Collection <Student> findAllStudentsByFaculty (Faculty faculty){
        return studentRepository.findAllStudentsByFaculty(faculty);
    }


}
