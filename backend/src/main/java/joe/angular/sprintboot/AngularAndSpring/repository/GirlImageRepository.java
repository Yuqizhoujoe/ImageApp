package joe.angular.sprintboot.AngularAndSpring.repository;

import joe.angular.sprintboot.AngularAndSpring.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlImageRepository extends JpaRepository<UserImage, Long> {
}
