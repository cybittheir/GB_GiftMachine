package gift_machine.engine.config;

public interface BaseInit<T> {
    String baseInit();
    String dumpFilePath();

    String exportFilePath();
//TODO:    String JSONFilePath();
}
