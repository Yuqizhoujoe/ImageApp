package joe.angular.sprintboot.AngularAndSpring.service;

import joe.angular.sprintboot.AngularAndSpring.entity.User;
import joe.angular.sprintboot.AngularAndSpring.shared.model.UserDto;

import java.util.*;

public interface UserService {

    public List<UserDto> getUsers();
    public UserDto getUserByUserId(Long userId);
    /*public User saveGirl(UserDto girlDto);
    public User deleteGirlImageByImageId(Long girlId, Long imageId);*/

}
