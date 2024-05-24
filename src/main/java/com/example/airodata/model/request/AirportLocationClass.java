package com.example.airodata.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportLocationClass {
    @JsonProperty("id")
    private String id;

    @JsonProperty("gmt")
    private String gmt;

    @JsonProperty("airport_id")
    private String airportId;

    @JsonProperty("iata_code")
    private String iataCode;

    @JsonProperty("city_iata_code")
    private String cityIataCode;

    @JsonProperty("icao_code")
    private String icaoCode;

    @JsonProperty("country_iso2")
    private String countryIso2;

    @JsonProperty("geoname_id")
    private String geonameId;

    @JsonProperty("latitude")
    private float latitude;

    @JsonProperty("longitude")
    private float longitude;

    @JsonProperty("airport_name")
    private String airportName;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("timezone")
    private String timezone;
}
