package Others.FreeMarker.utls;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class FileUtil {

    public void saveFile(StringWriter sw, String outputFile){

        FileWriter fw = null;

        try {
            fw = new FileWriter(outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //sw.write("some content...");
        try {
            fw.write(sw.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
