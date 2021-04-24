package joe.angular.sprintboot.AngularAndSpring.shared.model;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long userId;
    private String userName;
    private String userProfilePicByte;
    private String userProfilePicType;
    private Integer userProfilePicWidth;
    private Integer userProfilePicHeight;
    private List<UserImageDto> userImages = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Long userId, String userName, String userProfilePicByte, String userProfilePicType, Integer userProfilePicWidth, Integer userProfilePicHeight) {
        this.userId = userId;
        this.userName = userName;
        this.userProfilePicByte = userProfilePicByte;
        this.userProfilePicType = userProfilePicType;
        this.userProfilePicWidth = userProfilePicWidth;
        this.userProfilePicHeight = userProfilePicHeight;
    }

    public UserDto(Long userId, String userName, String userProfilePicByte, String userProfilePicType, Integer userProfilePicWidth, Integer userProfilePicHeight, List<UserImageDto> userImages) {
        this.userId = userId;
        this.userName = userName;
        this.userProfilePicByte = userProfilePicByte;
        this.userProfilePicType = userProfilePicType;
        this.userProfilePicWidth = userProfilePicWidth;
        this.userProfilePicHeight = userProfilePicHeight;
        this.userImages = userImages;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfilePicByte() {
        return userProfilePicByte;
    }

    public void setUserProfilePicByte(String userProfilePicByte) {
        this.userProfilePicByte = userProfilePicByte;
    }

    public String getUserProfilePicType() {
        return userProfilePicType;
    }

    public void setUserProfilePicType(String userProfilePicType) {
        this.userProfilePicType = userProfilePicType;
    }

    public Integer getUserProfilePicWidth() {
        return userProfilePicWidth;
    }

    public void setUserProfilePicWidth(Integer userProfilePicWidth) {
        this.userProfilePicWidth = userProfilePicWidth;
    }

    public Integer getUserProfilePicHeight() {
        return userProfilePicHeight;
    }

    public void setUserProfilePicHeight(Integer userProfilePicHeight) {
        this.userProfilePicHeight = userProfilePicHeight;
    }

    public List<UserImageDto> getUserImages() {
        return userImages;
    }

    public void setUserImages(List<UserImageDto> userImages) {
        this.userImages = userImages;
    }
}
