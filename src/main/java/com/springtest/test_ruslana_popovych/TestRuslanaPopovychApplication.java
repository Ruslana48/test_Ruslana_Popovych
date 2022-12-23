package com.springtest.test_ruslana_popovych;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class TestRuslanaPopovychApplication {
    private static HttpURLConnection connection;

    public static void main(String[] args) {
        BufferedReader reader;
        String line;
        StringBuffer responceContent=new StringBuffer();
        try{
            URL url=new URL("https://cex.io/");
            connection=(HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status=connection.getResponseCode();
            System.out.println(status);
            if(status>299){
                reader=new BufferedReader(new InputStreamReader((connection.getInputStream())));
                while ((line= reader.readLine())!=null){
                    responceContent.append(line);
                }
                reader.close();
            }
            System.out.println("response");
            System.out.println(responceContent.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            connection.disconnect();
        }
    }

}
