package pro.sky.hogwartsdb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwartsdb.model.Faculty;
import pro.sky.hogwartsdb.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository <Student, Long> {
    Collection <Faculty> findByAgeBetween (int age);
    Collection <Faculty> findAllByNameContains (String part);

}
