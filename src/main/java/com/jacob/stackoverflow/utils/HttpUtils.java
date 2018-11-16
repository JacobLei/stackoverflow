package com.jacob.stackoverflow.utils;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.domain.TagVisitInfo;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HttpUtils {
    public static final String SEARCH_URL_PRE = "https://stackoverflow.com/tags?page=";
    public static final String SEARCH_URL_POST = "&tab=popular";

    public static List<List<TagVisitInfo>> getInfo(int begin, int end){
        List<List<TagVisitInfo>> ret = new LinkedList<>();
        for(int i=begin; i<=end; ++i){
            String url = SEARCH_URL_PRE + Integer.toString(i) + SEARCH_URL_POST;
            try{
                Connection.Response response = Jsoup.connect(url)
                        .method(Connection.Method.GET).execute();
                if(response.statusCode() == 200){
                    ret.add(parse(response.body()));
                }else{
                    System.out.println("statusCode is : " + response.statusCode());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    private static List<TagVisitInfo> parse(String response){
        Document document = Jsoup.parse(response);
        Elements elements = document.select("div[class=grid-layout--cell tag-cell]");
        List<TagVisitInfo> list = new LinkedList<>();

        if(elements != null && elements.size() > 0){
            for(Element e : elements){
                TagVisitInfo tagVisitInfo = new TagVisitInfo();
                String tagName = e.select("a").first().text();
                String multiplierCounts = e.select("span[class=item-multiplier]")
                        .select("span[class=item-multiplier-count]").text();
                String tagExcerpt = e.select("div[class=excerpt]").text();
                String askedToday = e.select("div[class=grid--cell stats-row]")
                        .select("a").first().text().replaceAll("[^0-9]", "");
                String askedWeek = e.select("div[class=grid--cell stats-row]")
                        .select("a").last().text().replaceAll("[^0-9]", "");


                tagVisitInfo.setMultiplierCounts(multiplierCounts);
                tagVisitInfo.setAskedToday(askedToday);
                tagVisitInfo.setAskedWeek(askedWeek);
                tagVisitInfo.setSpiderTime(new Date());
                tagVisitInfo.setTagName(tagName);
                tagVisitInfo.setTagExcerpt(tagExcerpt);
                list.add(tagVisitInfo);

//                System.out.println("==================");
//                System.out.println(tagName);
//                System.out.println(multiplierCounts);
//                System.out.println(excerpt);
//                System.out.println(askedToday);
//                System.out.println(askedWeek);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        getInfo(1, 3);
    }
}
