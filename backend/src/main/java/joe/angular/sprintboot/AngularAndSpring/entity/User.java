package joe.angular.sprintboot.AngularAndSpring.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME", unique = true)
    @NotNull
    private String userName;

    @Lob
    @Column(name = "USER_PROFILE_PROFILE_PIC_BYTE")
    private byte[] userProfilePicByte;

    @Column(name = "USER_PROFILE_PIC_TYPE")
    private String userProfilePicType;

    @Column(name = "USER_PROFILE_PIC_WIDTH")
    private Integer userProfilePicWidth;

    @Column(name = "USER_PROFILE_PIC_HEIGHT")
    private Integer userProfilePicHeight;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<UserImage> userImgaes = new HashSet<UserImage>();

    public User() {
    }

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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

    public byte[] getUserProfilePicByte() {
        return userProfilePicByte;
    }

    public void setUserProfilePicByte(byte[] userProfilePicByte) {
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

    public Set<UserImage> getUserImgaes() {
        return userImgaes;
    }

    public void setUserImgaes(List<UserImage> userImgaes) {
        if (userImgaes != null) {
            for (UserImage userImgae : userImgaes) {
                userImgae.setUser(this);
            }
        }
        this.userImgaes = new HashSet<>(userImgaes);
    }

    public void addUserImage(UserImage userImage) {
        if (userImage != null) {
            userImage.setUser(null);
        }
        this.userImgaes.add(userImage);
    }

    public void removeUserImage(UserImage userImage) {
        if (userImage != null) {
            userImage.setUser(null);
        }
        this.userImgaes.remove(userImage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getUserName(), user.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
