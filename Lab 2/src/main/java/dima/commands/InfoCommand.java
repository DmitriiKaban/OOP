package dima.commands;

import dima.document.*;

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
                    System.out.println(file.getBasicInfo());
                } catch (IOException e) {
                    System.out.println("Incorrect image name!");
                }
                break;
            case "py":
                try {
                    file = new PythonFile(fileName);
                    System.out.println(file.getBasicInfo());
                } catch (IOException e) {
                    System.out.println("Incorrect file name!");
                }
                break;
            case "java":
                try {
                    file = new JavaFile(fileName);
                    System.out.println(file.getBasicInfo());
                } catch (IOException e) {
                    System.out.println("Incorrect file name!");
                }
                break;
            case "txt":
                try {
                    file = new TextFile(fileName);
                    System.out.println(file.getBasicInfo());
                } catch (IOException e) {
                    System.out.println("Incorrect file name!");
                }
                break;
            default:
                try {
                    file = new UnknownFile(fileName);
                    System.out.println(file.getBasicInfo());
                } catch (IOException e) {
                    System.out.println("Incorrect file name!");
                }
                break;
        }
    }
}
