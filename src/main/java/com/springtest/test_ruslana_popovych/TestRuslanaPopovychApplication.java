package com.springtest.test_ruslana_popovych;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;

@SpringBootApplication
public class TestRuslanaPopovychApplication {
    private static HttpURLConnection connection;
    @Autowired
    private MongoTemplate mongoTemplate;
    public static void main(String[] args) {

        SpringApplication.run(TestRuslanaPopovychApplication.class,args);
        //SpringApplication.run(TestRuslanaPopovychApplication.class, args);
//        final String url="https://cex.io/";
//        try{
//            Document document=Jsoup.connect(url).timeout(6000).get();
//            //System.out.println(document);
//            Elements el=document.select("table tr .tbody-row table-row");
//            for (Element element:el){
//                System.out.println(element.toString());
//            }
//            System.out.println("el");
//            System.out.println(el.select("table tr[class*=tbody-row table-row]"));
////            for (Element row:el){
//////                if(row.select("td.table-cell.table-body-cell:nth-of-type(2)").text().equals("")){
//////                    continue;
//////                }
//////                else {
////                final String ticker= String.valueOf(row.getElementsByClass("table-body-cell table-cell icon-sell"));
////                //System.out.println(row.getElementsByTag("td"));
////                System.out.println(ticker);
////                System.out.println(row.attr("a:href"));
////                //}
////            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        BufferedReader reader;
//        String line;
//        StringBuffer responceContent=new StringBuffer();
//        try{
//            URL url=new URL("https://cex.io/");
//            connection=(HttpURLConnection) url.openConnection();
//
//            connection.setRequestMethod("GET");
//            connection.setConnectTimeout(5000);
//            connection.setReadTimeout(5000);
//            int status=connection.getResponseCode();
//            System.out.println(status);
//            if(status>299){
//                reader=new BufferedReader(new InputStreamReader((connection.getInputStream())));
//                while ((line= reader.readLine())!=null){
//                    responceContent.append(line);
//                }
//                reader.close();
//            }
//            System.out.println("response");
//            System.out.println(responceContent.toString());

    }

}
