package com.socialwelfare.service.impl;


import com.socialwelfare.service.LocationService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class LocationServiceImpl 
implements LocationService {



@Override
public String getLocation(
double latitude,
double longitude){


String url =
"https://nominatim.openstreetmap.org/reverse?format=json&lat="
+latitude+
"&lon="
+longitude;



RestTemplate restTemplate =
new RestTemplate();



String response =
restTemplate.getForObject(
url,
String.class
);



return response;


}


}