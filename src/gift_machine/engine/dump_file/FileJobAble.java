package gift_machine.engine.dump_file;

import java.io.Serializable;
public interface FileJobAble {
    boolean saveDump(Serializable dump,String filePath);
    Object readDump(String filePath);
}
