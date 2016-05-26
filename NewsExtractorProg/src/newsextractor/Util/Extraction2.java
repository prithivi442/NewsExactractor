/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsextractor.Util;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Prithivi Raj
 */
public class Extraction2 {

    public static void Extract2(String link) throws IOException {
        Scanner input = new Scanner(System.in);
        URL url = new URL(link);
        // System.out.println(link);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line + "\n");
        }
        reader.close();
        /*String regexTitle = "<title>\\n\\t\\t\\t\\t\\s\\s(.*>)\\t\\t\\t\\t\\t</title>";
         Pattern patternTitle = Pattern.compile(regexTitle);
         Matcher matcherTitle = patternTitle.matcher(content);
         while (matcherTitle.find()) {
         System.out.println("#TITLE:" + matcherTitle.group(1));
         }
         String regexContent1 = "<p>(.*?)<br />";
         Pattern patternContent1 = Pattern.compile(regexTitle);
         Matcher matcherContent1 = patternContent1.matcher(content);
         while (matcherContent1.find()) {
         System.out.println("#CONTENTS:\n" + matcherContent1.group(1));
         }
         String regexContent2 = "<p>(.*?)<br />";
         Pattern patternContent2 = Pattern.compile(regexTitle);
         Matcher matcherContent2 = patternContent2.matcher(content);
         while (matcherContent2.find()) {
         System.out.println(matcherContent2.group(1));
         }*/
        System.out.println("Enter the name of file with its full path in .html ");
        String path = input.next();
        System.out.println("It might take few minutes.Please wait...");
        FileWriter writer = new FileWriter(input.next(path));
        writer.write(builder.toString());
        writer.close();
        /*if (Desktop.isDesktopSupported()) {       //it has been used to open the file automatically
            try {
                File myFile = new File(path);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                ex.getMessage();
            }*/
        }

    }


