package joe.angular.sprintboot.AngularAndSpring.entity;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;


@Entity
@Table(name = "USER_IMAGE")
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_ID")
    private long imageId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Lob
    @Column(name = "USER_PIC_BYTE", unique = true, nullable = false)
    private byte[] userPicByte;

    @Column(name = "USER_PIC_TYPE")
    private String userPicType;

    @Column(name = "USER_PIC_WIDTH")
    private Integer userPicWidth;

    @Column(name = "USER_PIC_HEIGHT")
    private Integer userPicHeight;

    public UserImage() {
    }

    public UserImage(String imageName, byte[] userPicByte, String userPicType, Integer userPicWidth, Integer userPicHeight) {
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getUserPicByte() {
        return userPicByte;
    }

    public void setUserPicByte(byte[] userPicByte) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImage userImage = (UserImage) o;
        return getImageId() == userImage.getImageId() &&
                Objects.equals(getUser(), userImage.getUser()) &&
                Objects.equals(getImageName(), userImage.getImageName()) &&
                Arrays.equals(getUserPicByte(), userImage.getUserPicByte()) &&
                Objects.equals(getUserPicType(), userImage.getUserPicType()) &&
                Objects.equals(getUserPicWidth(), userImage.getUserPicWidth()) &&
                Objects.equals(getUserPicHeight(), userImage.getUserPicHeight());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getImageId(), getUser(), getImageName(), getUserPicType(), getUserPicWidth(), getUserPicHeight());
        result = 31 * result + Arrays.hashCode(getUserPicByte());
        return result;
    }
}
