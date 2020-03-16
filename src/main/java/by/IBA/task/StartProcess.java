package by.IBA.task;

import by.IBA.task.exceptions.CMDKeyExceptionWriter;
import by.IBA.task.exceptions.FKeyExceptionWriter;
import by.IBA.task.exceptions.RKKeyExceptionWriter;
import by.IBA.task.parses.CommandParser;
import by.IBA.task.parses.FileParser;
import by.IBA.task.parses.Parser;
import by.IBA.task.parses.RegistryParser;

import java.util.logging.Logger;

import java.io.File;

public class StartProcess {
    private File input;
    private String[] args;
    private static Logger logger =  Logger.getLogger(StartProcess.class.getName());
    private String keyNotFound = "Key not found. Please try again: \\n" +
        " <-f filePath> \\n" +
        " <-cmd command> \\n" +
        " <-rk regKey> ";
    private Parser parser;


    public StartProcess(String[] args){
        this.args = args;
    }


    public void process(){
        if (CheckKeys.checkF(args[0])){
            input = Utils.constructFile(args[1]);
            FileIO fileIO = new FileIO(new FKeyExceptionWriter("file_err.txt"));
            parser = new FileParser(input, fileIO);

        }else if(CheckKeys.checkCMD(args[0])){
            FileIO fileIO = new FileIO(new CMDKeyExceptionWriter("cmd_err.txt"));
            parser = new CommandParser(fileIO, Utils.createStringCommand(args));

        }else if(CheckKeys.checkRK(args[0])){
            try {
                FileIO fileIO = new FileIO(new RKKeyExceptionWriter("rk_err.txt"));
                parser = new RegistryParser(fileIO, args[1], args[2]);
            }catch (NullPointerException e){
                logger.info("Arguments not found");
            }
        }else {
            logger.info(keyNotFound);
            System.exit(0);
        }
        parser.parse();
    }


}
