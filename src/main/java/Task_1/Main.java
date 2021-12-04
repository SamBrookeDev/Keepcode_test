package Task_1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, ArrayList<String>> numbersMap = new HashMap<String, ArrayList<String>>();


        JsonObject obj = getRequest("https://onlinesim.ru/api/getFreeCountryList");
        JsonArray codesArray = obj.getAsJsonArray("countries");

        for (int i = 0; i < codesArray.size(); i++) {
            if (!codesArray.get(i).getAsJsonObject().get("country").isJsonNull()) {
                int code = codesArray.get(i).getAsJsonObject().get("country").getAsInt();
                String country = codesArray.get(i).getAsJsonObject().get("country_text").getAsString();

                JsonObject object = getRequest("https://onlinesim.ru/api/getFreePhoneList?country=" + code);
                JsonArray numArray = object.getAsJsonArray("numbers");
                ArrayList<String> numberList = new ArrayList<String>();

                for (int j = 0; j < numArray.size(); j++) {
                    if (!numArray.get(j).getAsJsonObject().get("full_number").isJsonNull()) {
                        String number = numArray.get(j).getAsJsonObject().get("full_number").getAsString();
                        numberList.add(number);
                    }
                }
                numbersMap.put(country, numberList);
            }
        }
        //numbersMap.entrySet().forEach(System.out::println);

        Gson gson = new Gson();
        String json = gson.toJson(numbersMap);

        try (FileWriter writer = new FileWriter("result.json", false)) {

            writer.write(json);
            writer.flush();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


    //Добавим метод-обработчик URL для получения json

    public static JsonObject getRequest(String inputUrl) throws IOException {
        JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();
        URL url = new URL(inputUrl);
        String responce;

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        while ((responce = bufferedReader.readLine()) != null) {
            jsonObject = gson.fromJson(responce, JsonObject.class);
        }
        bufferedReader.close();
        return jsonObject;
    }


}
