/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp;

import com.rajesh.webapp.util.HttpClient;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dell
 */
public class Scrapper {

    public static void main(String[] args) throws URISyntaxException {
        try {
            String url = "http://www.thesaurus.com/browse/red?s=t";
          //  String param = "Keywords=book";
            String param = "qr=pen";
            String content = HttpClient.get(url);
            // String regex="<a class=\"job-item\"(.*?)href=\"(.*?)\"\\s>\\n(.*?)</a>\\n";
            // String regex="\"synonyms\":\\[(.*?)]";
            String regex = "<script>(.*?)\"synonyms\":\\[(.*?)],\"antonyms\":\\[(.*?)]";
         //  String content= HttpClient.Post(url, param);

            /**
             * regex for synonyms and antonyms
             *
             * <script>(.*?)"synonyms":\[(.*?)],"antonyms":\[(.*?)]
             */
            /**
             *
             * regex for more common words
             * "definition":"yes","synonyms":\[(.*?)](.*?)"targetTerm":"(.*?)"(.*?)"synonyms":\[(.*?)]
             *
             * working
             * {"_id":(.*?)"targetTerm":"(.*?)",(.*?)"synonyms":\[(.*?)](.*?)
             * {"_id":(.*?)"targetTerm":"(.*?)",(.*?)"synonyms":\[(.*?)]
             * "_id":(.*?),"entry":"(.*?)","targetTerm":"(.*?)",(.*?)"synonyms":\[(.*?)]
             */
            /**
             *
             * regex for differenticiating the term vulgarity clear
             * {(.*?),"isInformal":"(.*?)","isVulgar":(.*?),"term":"(.*?)","targetTerm":"(.*?)","targetSlug":"(.*?)"}
             */
            //<script>(.*?)"synonyms":\[(.*?)],"antonyms":\[(.*?)]
       /*     Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                String synonyms = matcher.group(2);
                String antonyms = matcher.group(3);
                // System.out.println("synonyms=>"+synonyms);
                //  System.out.println("antonyms=>"+antonyms);
                // String webContent=HttpClient.get(synonyms);
                pattern = Pattern.compile("\"term\":\"(.*?)\"");
                Matcher matcher1 = pattern.matcher(antonyms);
                //System.out.println(matcher1.group(0));
                while (matcher1.find()) {
                    String term = matcher1.group(1);
                    System.out.println("term=>" + term);
                    // System.out.println("Email:"+matcher1.group());
                }
                //   System.out.println("\n-----------------------------------------------------------------------------------------------------------------------\n");

            }*/
            String regdata="\"_id\":(.*?),\"entry\":\"(.*?)\",\"targetTerm\":\"(.*?)\",(.*?)\"synonyms\":\\[(.*?)]";
            Pattern pattern2 = Pattern.compile(regdata);
            Matcher matcher2 = pattern2.matcher(content);

            while (matcher2.find()) {
                String data = matcher2.group(5);
                String entry1 = matcher2.group(2);
                String targetTerm = matcher2.group(3);

                pattern2 = Pattern.compile("(.*?),\"isInformal\":\"(.*?)\",\"isVulgar\":(.*?),\"term\":\"(.*?)\",\"targetTerm\":\"(.*?)\",\"targetSlug\":\"(.*?)\"");
                Matcher matcher1 = pattern2.matcher(data);
                //System.out.println(matcher1.group(0));
                while (matcher1.find()) {
                    String term = matcher1.group(4);
                   // String targetTerm = matcher1.group(5);
                   // String entry = matcher1.group(5);
                    //System.out.println("entry1=>" + entry1);
                    //System.out.println("term=>" + term);
                    //System.out.println("targetTerm=>" + targetTerm);
                    // System.out.println("Email:"+matcher1.group());
                }
            }
             System.out.println(content);
        } catch (IOException e) {
            //  System.out.println(e.getMessage());
        }
    }
}
