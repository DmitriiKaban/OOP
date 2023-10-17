package dima.commands;

import dima.document.ImageFile;
import dima.util.Util;

import java.io.IOException;

public class InfoCommand implements Command {
    private final String fileName;

    public InfoCommand(String s) {
        this.fileName = s;
    }

    @Override
    public void invoke() {

        String extension = fileName.substring(fileName.indexOf(".") + 1);
        switch (extension) {
            case "png":
            case "jpg":
                try {
                    ImageFile image = new ImageFile(fileName);
                    image.printBasicInfo();
                } catch (IOException e) {
                    System.out.println("Incorrect image name!");
                }
                break;
            case "py":
                System.out.println("Python");
                break;
            case "java":
                System.out.println("Java");
                break;
            default:
                System.out.println("Another type of file");
                break;
        }
    }
}
