package eck.knp.eckknpspringboot.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateSuggestionsController {
    private final String SITE_IS_UP = "Site is up!";
    private final String SITE_IS_DOWN = "Site is up!";
    private final String INCORRECT_URL = "URL is incorrect!";


    @GetMapping("/suggestions")
    public String getSuggestions(@RequestParam String url){
        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCodeCategory = conn.getResponseCode() / 100;
            if (responseCodeCategory != 2 || responseCodeCategory != 2){
                return SITE_IS_DOWN;
            }
            else{
                return SITE_IS_UP; 
            }


        } catch (MalformedURLException e) {
            return INCORRECT_URL;
        } catch (IOException e) {
            return SITE_IS_DOWN;
        }
    }



}
