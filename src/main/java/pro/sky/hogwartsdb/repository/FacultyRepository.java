package pro.sky.hogwartsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwartsdb.model.Faculty;
import java.util.Collection;


public interface FacultyRepository extends JpaRepository <Faculty, Long> {
    Collection <Faculty> findAllByColor (String color);


}
