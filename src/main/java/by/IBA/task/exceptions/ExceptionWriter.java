package by.IBA.task.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Class for writing exceptions.
 */
public abstract class ExceptionWriter {
    private PrintWriter log;
    private FileWriter logFile;

    public ExceptionWriter(String fileName) {
        try {
            logFile = new FileWriter(fileName, true);
            log = new PrintWriter(logFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void writeError(Exception ex){
        log.printf("\n%s: %s\n", LocalDateTime.now(), ex.getMessage());
        ex.printStackTrace(log);
        log.flush();
    }

}
