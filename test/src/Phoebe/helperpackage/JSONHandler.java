package Phoebe.helperpackage;

import com.google.gson.Gson;
import Phoebe.basepackage.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by pvo on 21.10.14.
 */
public class JSONHandler {

    public static Object readStream(String filePath, Class<?> c) {
        Gson gson = new Gson();
        Object data = null;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);

            data =gson.fromJson(reader, c);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hiba JSONHandler-bol");
        }

        return data;
    }


}
