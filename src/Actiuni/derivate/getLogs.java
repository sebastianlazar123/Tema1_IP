package Actiuni.derivate;

import Actiuni.Action;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Properties;

public class getLogs extends Action {
    public getLogs(String nm, String pm){
        super(nm,pm);
    }
    public void _do(){   // Print the contents of the file
        try {
            Files.readAllLines(fetchLogFilePath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Here we can throw our custom exception
        }
    }

    public void send_log(String messageType, String message) throws IOException {
        // Write to file
        Path logFilePath = fetchLogFilePath();
        System.out.printf("Printing to: %s", logFilePath);
        // This is what will be written to the file
        String formattedString = String.format("Time when log was issued: %s\nMessage type: %s\nMessage: %s\n\n", new Date(), messageType, message);
        // This writes to the file, opening the file with Create option so in case the files doesn't exists it creates it,
        // write obviously to write in it and append to write at the end of the file
        Files.writeString(logFilePath, formattedString, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }

    private Path fetchLogFilePath() throws IOException {

        String defaultOutputPath = System.getProperty("user.home") + System.getProperty("file.separator") + "default_output.txt";

        Properties prop = new Properties();
        try {
            // the configuration file name
            String fileName = "config.conf";
            ClassLoader classLoader = getLogs.class.getClassLoader();

            // Make sure that the configuration file exists
            URL res = classLoader.getResource(fileName);

            String configFilePath = res.getPath().replaceAll("%20", " ");

            prop.load(new FileInputStream(configFilePath));
        }  catch (Exception e) {
            System.out.printf("Printing to default output file: %s\n", defaultOutputPath);
            // Here we can throw our custom exception
            return Paths.get(defaultOutputPath);
        }

        return Paths.get(prop.getProperty("path.to.log.file", defaultOutputPath));
    }
}
