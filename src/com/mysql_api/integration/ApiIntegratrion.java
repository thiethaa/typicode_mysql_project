package com.mysql_api.integration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class ApiIntegratrion {

    private static String api_baseUrl;

    public static HttpURLConnection sendRequest() {

        Properties properties = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/api_property.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        api_baseUrl = properties.getProperty("api_baseUrl");

        HttpURLConnection con = null;
        try {
            URL url = new URL(api_baseUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "authorization");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            System.out.println("Connection Status :" + con.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static String getResponse() {

        String content = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sendRequest().getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content += line;
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
}
