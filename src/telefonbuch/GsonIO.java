package telefonbuch;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonIO {

    public static void main(String[] args) {
        File input = new File("data.json");


        List<TelefonEntry> testList = new ArrayList<TelefonEntry>();
        testList.add(new TelefonEntry("Fabian", "Hammerschmidt", "01234567"));
        testList.add(new TelefonEntry("Max", "Mustermann", "93475329"));
        testList.add(new TelefonEntry("Linda","Fischer","1234890"));

        TelefonBook testTB = new TelefonBook();
        testTB.setTelefonBook(testList);

        writeGSON(testTB, input);
        System.out.println(readGSON(input).getTelefonBook());


    }


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
        Gson gson = new Gson();
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(gson.toJson(output));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
