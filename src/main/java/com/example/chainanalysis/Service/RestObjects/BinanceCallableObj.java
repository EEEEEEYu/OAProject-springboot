package com.example.chainanalysis.Service.RestObjects;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BinanceCallableObj implements Callable<List<DataObj>> {

    // A list of target url strings
    private final List<String> urls;

    public BinanceCallableObj(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public List<DataObj> call() throws Exception {
        List<DataObj> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for(String url:urls) {
            list.add(restTemplate.getForObject(url, BinanceDataObj.class));
        }
        return list;
    }
}
