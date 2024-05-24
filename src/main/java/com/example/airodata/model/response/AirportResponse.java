package com.example.airodata.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirportResponse {
    private String id;

    private String gmt;

    private String airportId;

    private String iataCode;

    private String cityIataCode;

    private String icaoCode;

    private String countryIso2;


    private String geonameId;

    private float latitude;

    private float longitude;


    private String airportName;
    private String countryName;

    private String phoneNumber;

    private String timezone;
}
