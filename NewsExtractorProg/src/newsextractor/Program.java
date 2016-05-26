/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsextractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import newsextractor.Util.Extraction1;
import newsextractor.Util.Extraction2;

/**
 *
 * @author Prithivi Raj
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String link = "http://www.nepalisamachar.com.np/";
        Scanner input = new Scanner(System.in);
        List<String> linkStore = new ArrayList<>();
        try {

            while (true) {
                System.out.println("Enter the category of news:");
                String content = Extraction1.Extract1(link, input.next());
                //System.out.println(builder);
                String regexLink = "<a href=\"(.*?)\"(.*?)/></a><p>(.*?)</p>";
                // String regexTitle = "<h2 class=\"archiveTitle\"><a href=\"(.*?) title=\"(.*?)\"(.*?)</a></h2>";
                Pattern patternLink = Pattern.compile(regexLink);
                Matcher matcherLink = patternLink.matcher(content);
                // Pattern patternTitle = Pattern.compile(regexTitle);
                // Matcher matcherTitle = patternTitle.matcher(builder);
                //while (matcherTitle.find()) {
                //String check = matcherTitle.group(1);
                int i = 0;
                if (matcherLink.find() == true) {
                    while (matcherLink.find()) {

                        //if (!check.equals((matcherLink.group(1)))) {
                        //System.out.println("search not found!");
                        //} else {
                        i++;
                        System.out.println(i + ". Title of news: " + matcherLink.group(3));
                        System.out.println("   Online Link:" + matcherLink.group(1));
                        System.out.println("");
                        linkStore.add(matcherLink.group(1));

                    }

                    System.out.println("Enter which news you want to read?[1-" + i + "]:");
                    int choose = input.nextInt() - 1;
                    for (int j = 0; j < i; j++) {
                        if (j == choose) {
                            Extraction2.Extract2(linkStore.get(j));
                        }
                    }
                } else {
                    System.out.println("Sorry!No news found.Please try again");
                    System.out.println("");

                }

                System.out.println("Press 'y if you want to continue or press 'n' if you want to exit");
                String choice = input.next();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println("THANK YOU FOR VISITING :)");
                    System.exit(0);
                }

            }

            //}
        } catch (IOException ioe) {

            System.out.println(ioe.getMessage());
        }

    }

}
