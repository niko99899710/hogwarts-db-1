package pro.sky.hogwartsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.hogwartsdb.model.Faculty;
import pro.sky.hogwartsdb.model.Student;

import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository <Faculty, Long> {
    Collection <Faculty> findAllByColor (String color);
    Collection <Faculty> findFacultyByStudents(Student students);


}
