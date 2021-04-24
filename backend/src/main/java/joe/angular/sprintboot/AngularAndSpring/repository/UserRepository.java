package joe.angular.sprintboot.AngularAndSpring.repository;

import joe.angular.sprintboot.AngularAndSpring.shared.model.UserDto;
import joe.angular.sprintboot.AngularAndSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

    User findByUserName(String userName);

}
