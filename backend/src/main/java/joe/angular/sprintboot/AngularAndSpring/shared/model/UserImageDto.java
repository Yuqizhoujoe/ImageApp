package joe.angular.sprintboot.AngularAndSpring.shared.model;

import java.util.Objects;

public class UserImageDto {

    private long imageId;
    private String imageName;
    private String userPicByte;
    private String userPicType;
    private Integer userPicWidth;
    private Integer userPicHeight;

    public UserImageDto() {
    }

    public UserImageDto(long imageId, String imageName, String userPicByte, String userPicType, Integer userPicWidth, Integer userPicHeight) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.userPicByte = userPicByte;
        this.userPicType = userPicType;
        this.userPicWidth = userPicWidth;
        this.userPicHeight = userPicHeight;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getUserPicByte() {
        return userPicByte;
    }

    public void setUserPicByte(String userPicByte) {
        this.userPicByte = userPicByte;
    }

    public String getUserPicType() {
        return userPicType;
    }

    public void setUserPicType(String userPicType) {
        this.userPicType = userPicType;
    }

    public Integer getUserPicWidth() {
        return userPicWidth;
    }

    public void setUserPicWidth(Integer userPicWidth) {
        this.userPicWidth = userPicWidth;
    }

    public Integer getUserPicHeight() {
        return userPicHeight;
    }

    public void setUserPicHeight(Integer userPicHeight) {
        this.userPicHeight = userPicHeight;
    }
}
