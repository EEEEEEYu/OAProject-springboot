package com.example.chainanalysis.Service.RestObjects;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BittrexCallableObj implements Callable<List<DataObj>> {

    private final List<String> urls;

    public BittrexCallableObj(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public List<DataObj> call() throws Exception {
        List<DataObj> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for(String url:urls) {
            list.add(restTemplate.getForObject(url, BittrexDataObj.class));
        }
        return list;
    }
}