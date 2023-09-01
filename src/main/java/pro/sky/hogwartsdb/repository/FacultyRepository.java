package pro.sky.hogwartsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.hogwartsdb.model.Faculty;

import java.util.List;


public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    List<Faculty> findFaculty (String Faculty, Long id);

}
