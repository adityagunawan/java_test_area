import sun.misc.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class ConvertBase64ToFile {
    public static void main(String[] args) throws IOException {

        String base64 = new String(Files.readAllBytes(Paths.get("/data1/uploads/base64.txt")));

        byte[] decodedImg = Base64.getDecoder()
                .decode(base64.toString().getBytes(StandardCharsets.UTF_8));

        if (decodedImg.length > 200000) { // if file size more than 200kb
            System.out.println("maximal size for upload is 100Kb!");
            return;
        }
        Path destinationFile = Paths.get("/data1/uploads", "mobil.jpg");
        Files.write(destinationFile, decodedImg);
        System.out.println("file saved, file size : " + decodedImg.length);
    }
}
