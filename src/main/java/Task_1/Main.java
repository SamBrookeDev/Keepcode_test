package Task_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, ArrayList<String>> result = new CountryPhoneNumbers().getMap();

        result.entrySet().forEach(System.out::println);

        CountryPhoneNumbers.createJsonFile(result.toString());



    }






}




