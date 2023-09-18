package pro.sky.hogwartsdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.hogwartsdb.model.Avatar;

import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository <Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);


}
