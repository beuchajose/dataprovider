package ch.spring.test.dataprovider.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/players")
public class DataController {

    String PLAYERS_LIST_URL = "http://hockeymanager.ch/api/RealPlayers/list";
    String PLAYERS_STATS_URL = "http://hockeymanager.ch/api/RealPlayers/stats";
    String GAME_STATUS_URL = "http://hockeymanager.ch/api/Games/status";
    String COUNTRIES_LIST_URL = "http://hockeymanager.ch/api/Countries/list";

    @RequestMapping("/list")
    @ResponseBody
    private String list() {
        return getPageContent(PLAYERS_LIST_URL);
    }

    @RequestMapping("/stats")
    @ResponseBody
    private String stats() {
        return getPageContent(PLAYERS_STATS_URL);
    }

    @ResponseBody
    @RequestMapping("/gamestatus")
    public String getGameStatus() {
        return getPageContent(GAME_STATUS_URL);
    }

    @RequestMapping("/countries")
    @ResponseBody
    public String getCountries() {
        return getPageContent(COUNTRIES_LIST_URL);
    }

    public String getPageContent(String url){
        HttpGet request = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response;
        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}