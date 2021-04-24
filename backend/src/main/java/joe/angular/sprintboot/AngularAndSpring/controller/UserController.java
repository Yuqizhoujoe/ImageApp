package joe.angular.sprintboot.AngularAndSpring.controller;

import joe.angular.sprintboot.AngularAndSpring.service.UserService;
import joe.angular.sprintboot.AngularAndSpring.shared.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> userDtos = userService.getUsers();

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        UserDto userDto = userService.getUserByUserId(userId);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

/*    @PutMapping
    public ResponseEntity<UserDto> saveChangedGirl(@RequestBody UserDto userDto) {

        UserDto user = girlService.saveGirl(userDto);

        if (girl != null) {
            return new ResponseEntity<>(girl, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{userId}/userImages/{imageId}")
    public ResponseEntity<UserDto> deleteGirlImageByImageId(@PathVariable("userId") Long userId,
                                                         @PathVariable("imageId") Long imageId)
    {
        UserDto girl = girlService.deleteGirlImageByImageId(girlId, imageId);

        if (girl != null) {
            return new ResponseEntity<>(girl, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
