package com.jacob.stackoverflow.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HttpUtils {
    public static final String SEARCH_URL_PRE = "https://stackoverflow.com/tags?page=";
    public static final String SEARCH_URL_POST = "&tab=popular";

    public static void getInfo(int begin, int end){
        for(int i=begin; i<=end; ++i){
            String url = SEARCH_URL_PRE + Integer.toString(i) + SEARCH_URL_POST;
            try{
                Connection.Response response = Jsoup.connect(url)
                        .method(Connection.Method.GET).execute();
                if(response.statusCode() == 200){
                    parse(response.body());
                }else{
                    System.out.println("statusCode is : " + response.statusCode());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void parse(String response){
        Document document = Jsoup.parse(response);
        Elements elements = document.select("div[class=grid-layout--cell tag-cell]");

        if(elements != null && elements.size() > 0){
            for(Element e : elements){
                String questionName = e.select("a").first().text();
                String multiplierCounts = e.select("span[class=item-multiplier]")
                        .select("span[class=item-multiplier-count]").text();
                String excerpt = e.select("div[class=excerpt]").text();
                String askedToday = e.select("div[class=grid--cell stats-row]")
                        .select("a").first().text().replaceAll("[^0-9]", "");
                String askedWeek = e.select("div[class=grid--cell stats-row]")
                        .select("a").last().text().replaceAll("[^0-9]", "");
                System.out.println("==================");
                System.out.println(questionName);
                System.out.println(multiplierCounts);
                System.out.println(excerpt);
                System.out.println(askedToday);
                System.out.println(askedWeek);
            }
        }
    }

    public static void main(String[] args) {
        getInfo(1, 3);
    }
}
