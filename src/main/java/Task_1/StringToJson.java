package Task_1;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class StringToJson {

    public static void createJsonFile(String input) {
        Gson gson = new Gson();
        String json = gson.toJson(input);

        try (
                FileWriter writer = new FileWriter("result.json", false)) {

            writer.write(json);
            writer.flush();

        } catch (
                IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
