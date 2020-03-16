package by.IBA.task.parses;

import by.IBA.task.FileIO;
import by.IBA.task.Utils;
import by.IBA.task.exceptions.WriterExceptionFactory;
import by.IBA.task.exceptions.Writers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistryParser implements Parser {
    private FileIO fileIO;
    private String path;
    private String key;
    private WriterExceptionFactory writerEx;

    public RegistryParser(FileIO fileIO,  String path, String key) {
        this.fileIO = fileIO;
        this.path = path;
        writerEx = fileIO.getWriterEx();
        this.key = key;
    }

    @Override
    public void parse() {
        try
        {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
                    "REG QUERY " + path + " /v " + key);
            Process p = builder.start();

            String lines = Utils.getLastBufferLine(p.getInputStream(), writerEx);
            //parse string from buffer
            if (!lines.equals("")) {
                String linesArr[] = lines.replaceAll("    ", " ").substring(1).split(" ");
                List<String> couple = new ArrayList<>();
                Matcher m = Pattern.compile("").matcher(lines);
                couple.add(linesArr[0]);
                couple.add("=");
                couple.add(linesArr[2]);
                fileIO.write(couple, new File("rk_out.txt"), "");
            }
            fileIO.writeErrors(p.getErrorStream());
        }
        catch (Exception e){
            Writers.writeError(writerEx, e);
        }
    }
}
