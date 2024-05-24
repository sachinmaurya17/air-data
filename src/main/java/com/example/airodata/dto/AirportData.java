package com.example.airodata.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "airport_data")
@Data
public class AirportData {
    @Id
    @Column(name = "id",updatable = false, nullable = false)
    private String id;

    @Column(name = "gmt")
    private String gmt;

    @Column(name = "airport_id")
    private String airportId;

    @Column(name = "iata_code")
    private String iataCode;

    @Column(name = "city_iata_code")
    private String cityIataCode;

    @Column(name = "icao_code")
    private String icaoCode;

    @Column(name = "country_iso2")
    private String countryIso2;

    @Column(name = "geoname_id")
    private String geonameId;

    @Column(name = "l_latitude")
    private float latitude;

    @Column(name = "l_longitude")
    private float longitude;
    @Column(name = "_longitude")
    private String airportName;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "timezone")
    private String timezone;
}
