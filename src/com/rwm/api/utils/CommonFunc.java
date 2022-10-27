package com.rwm.api.utils;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import static com.rwm.api.utils.Const.defaultPath;

public class CommonFunc {
    public static String imageHadle(String base64) throws IOException {
        // get extension file [0] and content [1]
        String[] strings = base64.split(",");
        String extension;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }

        // create a buffered image
        BufferedImage image = null;
        byte[] imageByte;
        imageByte = DatatypeConverter.parseBase64Binary(strings[1]);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();

        // write the image to a file
        UUID uuid = UUID.randomUUID();
        File outputFile = new File("");
        Files.write(Paths.get(defaultPath+uuid.toString()+"."+extension), imageByte);
        return uuid.toString()+"."+extension;
    }
}
