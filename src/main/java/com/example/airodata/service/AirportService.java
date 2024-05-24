package com.example.airodata.service;

import com.example.airodata.configuration.EnvironmentConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//@RequiredArgsConstructor
public class AirportService {
    @Autowired
    private EnvironmentConfiguration environmentConfiguration;

    @Autowired
    private ObjectMapper objectMapper;
    public void airportAddedToDataBase() {
        try{
            OkHttpClient okHttpClient = new OkHttpClient();
            String url = String.format("http://api.aviationstack.com/v1/airports?access_key=%s", environmentConfiguration.getAviationstackAccessKey());
//            MediaType mediaType = MediaType.parse("text/plain");
            log.info("given url is {} ",url);
            Request request = new Request.Builder()
                    .url(url).method("GET",null)
                    .build();
            try(Response response = okHttpClient.newCall(request).execute()){
                assert request.body() != null;
                String res = response.body().string();
                JSONPObject jsonpObject = new JSONPObject(res);
                System.out.println("res------"+res);
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
