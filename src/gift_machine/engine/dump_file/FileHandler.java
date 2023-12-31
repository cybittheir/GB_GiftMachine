package gift_machine.engine.dump_file;

import java.io.*;
import java.nio.file.Files;

public class FileHandler  implements FileJobAble{
    @Override
    public boolean saveDump(Serializable dump,String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath,false))){
            objectOutputStream.writeObject(dump);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object readDump(String filePath){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveResult(String data,String filePath){
        try (PrintWriter writer = new PrintWriter(filePath, "UTF-8")){
            writer.print(data);
            writer.close();
            System.out.println("File '"+ filePath + "' saved.");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
