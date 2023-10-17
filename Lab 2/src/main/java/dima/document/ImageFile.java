package dima.document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile extends BasicFile {

    public ImageFile(String fileName) throws IOException {
        super(fileName);
    }

    public String getImageSize() throws IOException {
        File imageFile = new File(super.folderPath + super.fileName);
        BufferedImage image = ImageIO.read(imageFile);

        int width = image.getWidth();
        int height = image.getHeight();
        return width + "x" + height;
    }

    public void printBasicInfo() throws IOException {
        super.printBasicInfo();
        System.out.println(getImageSize());;
    }

}
