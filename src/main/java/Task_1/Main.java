package Task_1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    //Добавим метод-обработчик URL для получения json

    public JsonObject getRequest(String inputUrl) throws IOException {
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
