package by.IBA.task.parses;

import by.IBA.task.FileIO;
import by.IBA.task.exceptions.WriterExceptionFactory;
import by.IBA.task.exceptions.Writers;

import java.io.*;

public class CommandParser implements Parser{
    private FileIO fileIO;
    private WriterExceptionFactory writerEx;
    private String commands;

    public CommandParser( FileIO fileIO, String commands) {
        this.fileIO = fileIO;
        this.writerEx = fileIO.getWriterEx();
        this.commands = commands;
    }

    @Override
    public void parse() {
        try
        {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", commands);
            Process p = builder.start();
            fileIO.write(p.getInputStream(),new File("cmd_out.txt"));
            fileIO.writeErrors(p.getErrorStream());
        }
        catch (Exception e){
            Writers.writeError(writerEx, e);
        }
    }
}
