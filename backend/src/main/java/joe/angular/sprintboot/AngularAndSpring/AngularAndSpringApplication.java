package joe.angular.sprintboot.AngularAndSpring;

import joe.angular.sprintboot.AngularAndSpring.entity.User;
import joe.angular.sprintboot.AngularAndSpring.entity.UserImage;
import joe.angular.sprintboot.AngularAndSpring.repository.UserRepository;
import joe.angular.sprintboot.AngularAndSpring.service.UserServiceImpl;
import joe.angular.sprintboot.AngularAndSpring.util.BlobDataHanlder;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
// @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class AngularAndSpringApplication {

	private static Logger logger = LoggerFactory.getLogger(AngularAndSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AngularAndSpringApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository repository, UserServiceImpl service) throws IOException {
		File fileFolder = new ClassPathResource("/images").getFile();
		return args -> {

			// save the picture into DB
			for (File folder : fileFolder.listFiles()) {
				boolean isUserExist = false;
				if (folder.isDirectory()) {
					String folderName = folder.getName();

					User user = new User();
					user.setUserName(folderName);
					List<UserImage> userImages = new ArrayList<>();

					for (File picture : folder.listFiles()) {
						byte[] imageBytes = null;
						Integer width = null;
						Integer height = null;

						try {
							// read image file byte
							FileInputStream fileInputStream = new FileInputStream(picture);
							byte[] bytes = new byte[(int) picture.length()];
							fileInputStream.read(bytes);

							// read imgae width and height
							BufferedImage bimg = ImageIO.read(picture);
							width = bimg.getWidth();
							height = bimg.getHeight();

							// compress the bytes
							imageBytes = BlobDataHanlder.compressBytes(bytes);
							fileInputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}

						String[] pictureName = picture.getName().split("." + FilenameUtils.getExtension(picture.getName()));
						if (pictureName[0].contains("Profile")) {
							user.setUserProfilePicByte(imageBytes);
							user.setUserProfilePicType(FilenameUtils.getExtension(picture.getName()));
							user.setUserProfilePicHeight(height);
							user.setUserProfilePicWidth(width);
						} else {
							UserImage userImage = new UserImage(
									pictureName[0],
									imageBytes,
									FilenameUtils.getExtension(picture.getName()),
									width,
									height);
							userImages.add(userImage);
						}
					}

					user.setUserImgaes(userImages);
					User userFromDB = repository.findByUserName(user.getUserName());
					if (userFromDB == null) {
						repository.save(user);
					} else {
						logger.info(userFromDB.toString());
					}
				}
			}
		};
	}

}

// alternative solution but String is too long
// we might need the compress and uncompress the image before saving into DB
/*									String encodeBase64 = null;
									FileInputStream fileInputStream = null;
									try {
										String extension = FilenameUtils.getExtension(file.getName());
										fileInputStream = new FileInputStream(file);
										byte[] bytes = new byte[(int) file.length()];
										fileInputStream.read(bytes);
										encodeBase64 = Base64.getEncoder().encodeToString(bytes);
										fileInputStream.close();

										girl.setGirlPicByte("data:image/" + extension + ";base64," + encodeBase64);
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}*/


/*	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	@Configuration
	static class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.anyRequest().authenticated()
					.and()
					.oauth2ResourceServer().jwt();

			// process CORS annotations
			http.cors();

			// force a non-empty response body for 401's to make the response more browser friendly
			Okta.configureResourceServer401ResponseBody(http);
		}
	}*/