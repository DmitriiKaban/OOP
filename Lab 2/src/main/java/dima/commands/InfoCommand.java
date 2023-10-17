package dima.commands;

import dima.document.Document;
import dima.document.ImageFile;
import dima.document.JavaFile;
import dima.document.PythonFile;

import javax.print.Doc;
import java.io.IOException;

public class InfoCommand implements Command {
    private final String fileName;

    public InfoCommand(String s) {
        this.fileName = s;
    }

    @Override
    public void invoke() {

        String extension = fileName.substring(fileName.indexOf(".") + 1);
        Document file;
        switch (extension) {
            case "png":
            case "jpg":
                try {
                    file = new ImageFile(fileName);
                    file.printBasicInfo();
                } catch (IOException e) {
                    System.out.println("Incorrect image name!");
                }
                break;
            case "py":
                try {
                    file = new PythonFile(fileName);
                    file.printBasicInfo();
                } catch (IOException e) {
                    System.out.println("Incorrect image name!");
                }
                System.out.println("Python");
                break;
            case "java":
                try {
                    file = new JavaFile(fileName);
                    file.printBasicInfo();
                } catch (IOException e) {
                    System.out.println("Incorrect image name!");
                }
                System.out.println("Java");
                break;
            default:
                System.out.println("Another type of file");
                break;
        }
    }
}
