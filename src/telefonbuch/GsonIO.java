package telefonbuch;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;


public class GsonIO {

    public static TelefonBook readGSON(File input) {

            try {
                JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
                JsonObject fileObject = fileElement.getAsJsonObject();
                TelefonBook tB = new Gson().fromJson(fileObject, TelefonBook.class);
                return tB;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return null;
        }


    public static void writeGSON(TelefonBook output, File path) {
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(new Gson().toJson(output));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
