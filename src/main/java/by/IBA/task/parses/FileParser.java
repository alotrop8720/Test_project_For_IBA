package by.IBA.task.parses;

import by.IBA.task.FileIO;
import by.IBA.task.ParseMap;
import by.IBA.task.Utils;

import java.io.File;
import java.util.List;

public class FileParser implements Parser{
    private ParseMap<String, String> map = new ParseMap<>();
    private List<String> params;
    private FileIO fileIO;

    public FileParser(File file, FileIO fileIO) {
        this.fileIO = fileIO;
        params = fileIO.readRowWise(file);
    }

    @Override
    public void parse() {
        File fileOut = new File("file_out.txt");
        if(Utils.checkFile(params)){
            for (String param: params){
                String[] tmp = param.split("=");
                if (tmp.length == 2 && !tmp[0].equals("") && !tmp[1].equals(""))
                    map.put(tmp[0], tmp[1]);
            }
            fileIO.write(map, fileOut);
        }else {
            fileIO.write(params, fileOut);
        }
    }
}
