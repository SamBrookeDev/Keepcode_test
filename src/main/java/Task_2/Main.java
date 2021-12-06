package Task_2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {


    public static void main(String[] args) throws IOException {

            JsonObject jsonObject = new JsonObject();
            Gson gson = new Gson();
            URL url = new URL("http://onlinesim.ru/price-list");
            String responce;
            String line;

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();

            while ((responce = bufferedReader.readLine()) != null) {
                sb.append(responce);
                sb.append("\n");
            }

            bufferedReader.close();
        System.out.println(sb.toString());
        }
    }

