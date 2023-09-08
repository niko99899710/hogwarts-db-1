package pro.sky.hogwartsdb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.hogwartsdb.model.Faculty;
import pro.sky.hogwartsdb.model.Student;

import java.util.Collection;
@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    Collection <Student> findAllByAge(int age);
    Collection <Student> findByAgeBetween (int age1,int age2 );

    Collection <Student> findAllByNameContains (String part);

    Collection <Student> findAllStudentsByFaculty (Faculty faculty);

}
