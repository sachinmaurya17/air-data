package com.example.airodata.service;

import com.example.airodata.configuration.EnvironmentConfiguration;
import com.example.airodata.dto.AirportData;
import com.example.airodata.model.response.AirportResponse;
import com.example.airodata.repository.AirDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
//@RequiredArgsConstructor
public class AirportService {
    @Autowired
    private EnvironmentConfiguration environmentConfiguration;

    @Autowired
    private AirDataRepository airDataRepository;

    public void airportAddedToDataBase() {
        try{
            OkHttpClient okHttpClient = new OkHttpClient();
            String url = String.format("http://api.aviationstack.com/v1/airports?access_key=%s", environmentConfiguration.getAviationstackAccessKey());
            log.info("given url is {} ",url);
            Request request = new Request.Builder()
                    .url(url).method("GET",null)
                    .build();
            try(Response response = okHttpClient.newCall(request).execute()){
                assert request.body() != null;
                String res = response.body().string();
                JSONObject jsonObject = new JSONObject(res);
                if(jsonObject.has("data")){
                    JSONArray jsonArray =  jsonObject.getJSONArray("data");
                    List<AirportData> fres = new ArrayList<>();
                    for(int i = 0; i < jsonArray.length(); i++){
                        try{
                            JSONObject object = (JSONObject) jsonArray.get(i);
                            String phonenumber;
                            try{
                                phonenumber = ObjectUtils.isEmpty(object.get("phone_number")) ? "" : (String) object.get("phone_number");
                            }catch (Exception e){
                                phonenumber = "";
                            }
                            System.out.println("object: " +object);
                            AirportData airportData = new AirportData();
                            airportData.setAirportId(object.getString("airport_id"));
                            airportData.setAirportName(object.getString("airport_name"));
                            airportData.setId(object.getString("id"));
                            airportData.setIataCode("iata_code");
                            airportData.setTimezone(object.getString("timezone"));
                            airportData.setLatitude(object.getFloat("latitude"));
                            airportData.setLongitude(object.getFloat("longitude"));
                            airportData.setGmt(object.getString("gmt"));
                            airportData.setGeonameId(object.getString("geoname_id"));
                            airportData.setIcaoCode(object.getString("icao_code"));
                            airportData.setCityIataCode(object.getString("city_iata_code"));
                            airportData.setCountryName(object.getString("country_name"));
                            airportData.setPhoneNumber(phonenumber);
                            airportData.setCountryIso2(object.getString("country_iso2"));
                            fres.add(airportData);
                        }catch(Exception e){
                            e.printStackTrace();
                        }

                    }
                    airDataRepository.saveAll(fres);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<AirportResponse> countryAirPort() {
        List<AirportData> fres = airDataRepository.findAll();
        return fres.stream().map(airportData -> mapAirportData(airportData)).collect(Collectors.toList());
    }

    private AirportResponse mapAirportData(AirportData airportData) {
        return  AirportResponse.builder()
                .id(airportData.getId())
                .airportName(airportData.getAirportName())
                .airportId(airportData.getAirportId())
                .gmt(airportData.getGmt())
                .iataCode(airportData.getIataCode())
                .cityIataCode(airportData.getCityIataCode())
                .longitude(airportData.getLongitude())
                .latitude(airportData.getLatitude())
                .timezone(airportData.getTimezone())
                .icaoCode(airportData.getIcaoCode())
                .phoneNumber(airportData.getPhoneNumber())
                .countryIso2(airportData.getCountryIso2())
                .countryName(airportData.getCountryName())
                .geonameId(airportData.getGeonameId())
                .build();
    }
}
