package joe.angular.sprintboot.AngularAndSpring.util;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class BlobDataHanlder {

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while(!deflater.finished()) {
                int count = deflater.deflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (DataFormatException | IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }

    public static String encodeImage(String picType, byte[] bytes) {
        String encodeBase64 = Base64.getEncoder().encodeToString(bytes);
        String result = "data:image/" + picType + ";base64," + encodeBase64;
        return result;
    }

    public static byte[] decodeImage(String image) {
        String[] array = image.split(";base64,");
        byte[] decodeBase64 = Base64.getDecoder().decode(array[1]);
        return decodeBase64;
    }
}
