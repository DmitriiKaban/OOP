package md.kubuntu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public Logger() {
    }

    public void log(String message) {
        final String logFileName = "university_logs.log";
        try (FileWriter fileWriter = new FileWriter(logFileName, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());

            printWriter.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





