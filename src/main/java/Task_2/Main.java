package Task_2;

import Task_1.CountryPhoneNumbers;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {


    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        CountryPhoneNumbers obj = new CountryPhoneNumbers();
        JsonObject input = obj.getRequest("https://onlinesim.ru/price-list-data?type=receive");
        JsonObject inputCountries = input.getAsJsonObject("countries");
        JsonObject inputText = input.getAsJsonObject("text");
        JsonObject inputList = input.getAsJsonObject("list");
        ArrayList<String> key = new ArrayList<>(inputCountries.keySet());
        ArrayList<String> country = new ArrayList<>();
        Map<String, Map<String, String>> resultMap = new HashMap<>();

        for (String k : key) {

            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            Map<String, String> myMap = gson.fromJson(inputList.get(k), type);
            String countryName = inputText.getAsJsonObject().get("country_" + k).getAsString();
            resultMap.put(countryName, myMap);

        }

        resultMap.entrySet().forEach(System.out::println);

        String json = gson.toJson(resultMap);

        try (FileWriter writer = new FileWriter("resultMa.json", false)) {

            writer.write(json);
            writer.flush();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
    }

}



