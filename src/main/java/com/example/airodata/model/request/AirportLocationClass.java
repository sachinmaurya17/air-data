package com.example.airodata.model.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportLocationClass {
    private String id;
    private String gmt;
    private String airport_id;
    private String iata_code;
    private String city_iata_code;
    private String icao_code;
    private String country_iso2;
    private String geoname_id;
    private String latitude;
    private String longitude;
    private String airport_name;
    private String country_name;
    private String phone_number;
    private String timezone;
}
