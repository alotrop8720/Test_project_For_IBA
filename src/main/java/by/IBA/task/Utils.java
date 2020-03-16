package by.IBA.task;

import by.IBA.task.exceptions.WriterExceptionFactory;
import by.IBA.task.exceptions.Writers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Utils {

    /**
     * Check file's data structure.
     * @param params - list which have key-value in element
     */
    public static boolean checkFile(List<String> params){
        for (String s: params)
            if (!Pattern.compile("[\\p{Punct}|\\w|\\d| ]*=[\\p{Punct}|\\w|\\d| ]*").matcher(s).matches())
                return false;
        return true;
    }


    private static String sep = System.getProperty("file.separator");

    /**
     * Create string array to String command.
     * @param args - array commands
     * @return String command.
     */
    public static String createStringCommand(String[] args){
        List<String> list = Arrays.asList(args);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(args[1]);
        for (int i = 2; i < list.size(); i++) {
            if(list.get(i).contains(sep) || list.get(i).contains("-")) {
                stringBuilder.append(" ");
                stringBuilder.append(args[i]);
            }else{
                stringBuilder.append(" && ");
                stringBuilder.append(args[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static Logger logger = Logger.getLogger(Utils.class.getName());
    /**
     * Create difference between Relative path and absolute path.
     * @param filePath - path file.
     * @return right path.
     */
    public static File constructFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.exists()) {
                if (filePath.contains(":")) {
                    return file;
                } else {
                    return new File(file.getCanonicalPath());
                }
            } else {
                logger.info("File not found.");
                System.exit(0);
            }
        }catch (Exception e){
            logger.info("File not found.");
            System.exit(0);
        }
        throw new RuntimeException();
    }

    /**
     *
     * @return last line from buffer.
     */
    public static String getLastBufferLine(InputStream stream, WriterExceptionFactory writerEx){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

            String line;
            List<String> result = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null){
                result.add(line);
            }
            bufferedReader.close();
            return result.get(result.size()-2);
        } catch (IOException e) {
            Writers.writeError(writerEx, e);
        }
        return null;
    }
}
