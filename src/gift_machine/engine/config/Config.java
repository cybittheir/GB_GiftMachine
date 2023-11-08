package gift_machine.engine.config;

import gift_machine.engine.dump_file.FileHandler;
import java.io.File;

public class Config implements BaseInit{
    FileHandler fileHandler = new FileHandler();
    public static String getFilePath(){
        String path = "";
        String file = "stock.dump";
        return path + file;
    }
    public static boolean checkFile(){
        return new File(getFilePath()).isFile();
    }

    public String baseInit(){
        if(checkFile()){
            return getFilePath();
        }
        return null;
    }
    public String dumpFilePath(){
        return getFilePath();
    }

}
