package com.socialwelfare.service;


public interface LocationService {


    String getLocation(
        double latitude,
        double longitude
    );

}