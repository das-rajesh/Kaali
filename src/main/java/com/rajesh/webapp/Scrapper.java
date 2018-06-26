/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp;

import com.rajesh.webapp.util.HttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dell
 */
public class Scrapper {

    public static void main(String[] args) {
        try {
            String url="http://www.thesaurus.com/browse/good?s=ts";
            String param="Keywords=java";
           String content= HttpClient.Post(url, "");
           String regex="<a class=\"job-item\"(.*?)href=\"(.*?)\"\\s>\\n(.*?)</a>\\n";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(content);
            while(matcher.find()){
                String link=matcher.group(2);
                String title=matcher.group(3);
                System.out.println("link=>"+link);
                System.out.println("title=>"+title.trim());
                String webContent=HttpClient.get(link);
                pattern=Pattern.compile(HttpClient.getEmailRegEx());
                Matcher matcher1=pattern.matcher(webContent);
                if(matcher1.find()){
                    System.out.println("Email:"+matcher1.group());
                }
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            }
           System.out.println(content);
         } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
