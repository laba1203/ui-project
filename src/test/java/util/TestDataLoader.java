package util;

import java.io.File;

public class TestDataLoader {

    private static final String dirPath = "src/test/test.data/";

    public static String getTestDataFile(String fileName){
        return new File(dirPath + fileName).getAbsolutePath();
    }
}
