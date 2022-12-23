package com.springtest.test_ruslana_popovych;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;

@SpringBootApplication
public class TestRuslanaPopovychApplication {
    private static HttpURLConnection connection;

    public static void main(String[] args) {
        SpringApplication.run(TestRuslanaPopovychApplication.class, args);
//        final String url="https://cex.io/";
//        try{
//            Document document=Jsoup.connect(url).get();
//            for (Element row:document.select(
//                    "table.coin-block-table tr")){
////                if(row.select("td.table-cell.table-body-cell:nth-of-type(2)").text().equals("")){
////                    continue;
////                }
////                else {
//                final String ticker=row.select(".table-body-cell table-cell icon-sell").text();
//                //System.out.println(row.getElementsByTag("td"));
//                System.out.println(ticker);
//                //}
//            }
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
