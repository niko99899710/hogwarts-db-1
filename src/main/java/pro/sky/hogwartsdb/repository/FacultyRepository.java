package pro.sky.hogwartsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwartsdb.model.Faculty;


public interface FacultyRepository extends JpaRepository <Faculty, Long> {
}
