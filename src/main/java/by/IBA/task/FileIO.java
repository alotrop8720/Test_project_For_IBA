package by.IBA.task;

import by.IBA.task.exceptions.ExceptionWriter;
import by.IBA.task.exceptions.WriterExceptionFactory;
import by.IBA.task.exceptions.Writers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FileIO {
    private WriterExceptionFactory writerEx;

    public FileIO(WriterExceptionFactory writerEx) {
        this.writerEx = writerEx;
    }

    public List<String> readRowWise(File file){
        try {
            return Files.readAllLines(Paths.get(file.getPath()));
        } catch (IOException e) {
            Writers.writeError(writerEx, e);
        }
        return null;
    }

    public WriterExceptionFactory getWriterEx() {
        return writerEx;
    }

    /**
     * Write in each line each element from the collection.
     * @param text - collection with string elements.
     * @param outFile - write file.
     */
    public void write(Collection<String> text, File outFile){
        try {
            FileWriter fileWriter = new FileWriter(outFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(String s : text) {
                bufferedWriter.write(s + "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            Writers.writeError(writerEx, e);
        }
    }

    public void write(Collection<String> text, File outFile, String sep){
        try {
            FileWriter fileWriter = new FileWriter(outFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(String s : text) {
                bufferedWriter.write(s + sep);
            }
            bufferedWriter.close();
        } catch (Exception e) {
            Writers.writeError(writerEx, e);
        }
    }

    /**
     * Write in each line each key-value from the parse map.
     * @param map - map with key-value elements.
     * @param outFile - write file.
     */
    public <K,V> void write(ParseMap<K,V> map, File outFile){
        try {
            FileWriter fileWriter = new FileWriter(outFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i = 0; i < map.keys.size(); i++) {
                bufferedWriter.write(map.keys.get(i).toString()
                        + "\n" + map.values.get(i).toString()+ "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            Writers.writeError(writerEx, e);
        }
    }

    /**
     * Write in each line from stream.
     * @param outFile - write file.
     */
    public void write(InputStream stream, File outFile){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            FileWriter fileWriter = new FileWriter(outFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            Writers.writeError(writerEx, e);
        }
    }

    /**
     * Write errors from stream.
     */
    public void writeErrors(InputStream stream){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            BufferedReader bufferErr = new BufferedReader(inputStreamReader);

            String err = "";
            String line;
            while((line = bufferErr.readLine()) != null) {
                err += line;
            }
            Writers.writeError(writerEx, new Exception(err));
            bufferErr.close();
        }catch (IOException e){
            Writers.writeError(writerEx, e);
        }
    }

}
