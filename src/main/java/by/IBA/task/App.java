package by.IBA.task;

import java.util.logging.Logger;

public class App 
{
    private static Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        if (args.length < 2){
            logger.info("Arguments not found.");
            System.exit(0);
        }
        StartProcess startProcess = new StartProcess(args);
        startProcess.process();
    }
}
