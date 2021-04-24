package joe.angular.sprintboot.AngularAndSpring.service;

import joe.angular.sprintboot.AngularAndSpring.entity.User;
import joe.angular.sprintboot.AngularAndSpring.entity.UserImage;
import joe.angular.sprintboot.AngularAndSpring.repository.GirlImageRepository;
import joe.angular.sprintboot.AngularAndSpring.repository.UserRepository;
import joe.angular.sprintboot.AngularAndSpring.shared.model.UserDto;
import joe.angular.sprintboot.AngularAndSpring.shared.model.UserImageDto;
import joe.angular.sprintboot.AngularAndSpring.util.BlobDataHanlder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GirlImageRepository girlImageRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserDto> getUsers() {

        List<UserDto> userDtos = new ArrayList<>();

        List<User> users = userRepository.findAll();

        if (users != null && users.size() > 0) {

            // Session session = entityManager.unwrap(Session.class);

            for (User user : users) {
                UserDto userDto = new UserDto(
                        user.getUserId(),
                        user.getUserName(),
                        BlobDataHanlder.encodeImage(
                                user.getUserProfilePicType(),
                                BlobDataHanlder.decompressBytes(user.getUserProfilePicByte())),
                        user.getUserProfilePicType(),
                        user.getUserProfilePicWidth(),
                        user.getUserProfilePicHeight()
                );
                userDtos.add(userDto);
            }

            // session.close();
        }
        return userDtos;
    }

    public UserDto getUserByUserId(Long userId) {
        User user = userRepository.findByUserId(userId);
        Set<UserImage> userImages = user.getUserImgaes();
        UserDto userDto = null;
        if (user != null) {
            userDto = new UserDto(
                    user.getUserId(),
                    user.getUserName(),
                    BlobDataHanlder.encodeImage(
                            user.getUserProfilePicType(),
                            BlobDataHanlder.decompressBytes(user.getUserProfilePicByte())
                    ),
                    user.getUserProfilePicType(),
                    user.getUserProfilePicWidth(),
                    user.getUserProfilePicHeight(),
                    transformUserImageToDto(userImages)
            );
        }

        return userDto;
    }

    private List<UserImageDto> transformUserImageToDto(Set<UserImage> userImages) {
        List<UserImageDto> userImageDtos = new ArrayList<>();
        for (UserImage userImage : userImages) {
            UserImageDto userImageDto = new UserImageDto(
                    userImage.getImageId(),
                    userImage.getImageName(),
                    BlobDataHanlder.encodeImage(
                            userImage.getUserPicType(),
                            BlobDataHanlder.decompressBytes(userImage.getUserPicByte())),
                    userImage.getUserPicType(),
                    userImage.getUserPicWidth(),
                    userImage.getUserPicHeight()
            );
            userImageDtos.add(userImageDto);
        }
        return userImageDtos;
    }

/*    @Override
    public Girl saveGirl(GirlDto girlDto) {

        Girl girl = new Girl();
        girl.setGirlId(girlDto.getGirlId());
        girl.setGirlName(girlDto.getGirlName());

        Set<GirlImage> girlImages = new HashSet<>();
        for (GirlImageDto girlImageDto : girlDto.getGirlImages()) {
            GirlImage girlImage = new GirlImage();
            girlImage.setImageId(girlImageDto.getImageId());
            girlImage.setGirlPicType(girlImageDto.getGirlPicType());
            girlImage.setGirlPicHeight(girlImageDto.getGirlPicHeight());
            girlImage.setGirlPicWidth(girlImageDto.getGirlPicWidth());
            girlImage.setGirlPicByte(BlobDataHanlder.compressBytes(
                    BlobDataHanlder.decodeImage(girlImageDto.getGirlPicByte())
            ));
            girlImage.setGirlProfile(girlImageDto.getGirlProfile());

            girlImages.add(girlImage);
        }

        girl.setGirlImages(girlImages);

        Girl saved = girlRepository.save(girl);

        return saved;
    }

    @Override
    public Girl deleteGirlImageByImageId(Long girlId, Long imageId) {
        Optional<Girl> girlDb = girlRepository.findById(girlId);
        if (girlDb.isPresent()) {
            Girl girl = girlDb.get();
            Set<GirlImage> girlImages = girl.getGirlImages();
            for (GirlImage girlImage : girlImages) {
                if (girlImage.getImageId() == imageId) {
                    girl.removeImage(girlImage);
                }
            }

            Girl saved = girlRepository.save(girl);
            return saved;
        }

        return null;
    }*/
}
