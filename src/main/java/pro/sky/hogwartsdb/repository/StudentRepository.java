package pro.sky.hogwartsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwartsdb.model.Student;

import java.util.List;


public interface StudentRepository extends JpaRepository <Student, Long> {
 List<Student> findStudent (String Student, Long id);
}
