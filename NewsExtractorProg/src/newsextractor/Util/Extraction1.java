/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsextractor.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Prithivi Raj
 */
public class Extraction1 {

    Scanner input = new Scanner(System.in);

    public static String Extract1(String link, String category) throws IOException {
        URL url = new URL(link);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        byte[] data = ("s=" + category).getBytes();
        System.out.println("please wait...");
        os.write(data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line + "\n");
        }
        reader.close();

        return builder.toString();

    }

}
