package pro.sky.hogwartsdb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwartsdb.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
