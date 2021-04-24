package joe.angular.sprintboot.AngularAndSpring.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/girls")
public class GirlPictureController {

    @Autowired
    ServletContext context;

    @GetMapping(value = "/getImages")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<String>> getImages() throws IOException {
        List<String> images = new ArrayList<>();
        File fileFolder = new ClassPathResource("images").getFile();
        if (fileFolder != null) {
            for (final File file: fileFolder.listFiles()) {
                if (!file.isDirectory()) {
                    String encodeBase64 = null;
                    try {
                        String extension = FilenameUtils.getExtension(file.getName());
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bytes = new byte[(int) file.length()];
                        fileInputStream.read(bytes);
                        encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        images.add("data:image/"+extension+";base64,"+encodeBase64);
                        fileInputStream.close();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }

        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}
