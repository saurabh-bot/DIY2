package org.example.helper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.models.DistrictResponse;
import org.example.models.SessionResponse;
import org.example.models.StateResponse;
import org.example.constants.EndPoints;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CowinAPIService {
    public CowinAPIService() {
        RestAssured.baseURI = "https://cdn-api.co-vin.in/api/v2/";
    }

    public StateResponse getAllStates() {
        Response response = RestAssured.given().contentType(ContentType.JSON).get(EndPoints.GET_ALL_STATES).andReturn();
        StateResponse stateResponse = response.getBody().as(StateResponse.class);
        return stateResponse;
    }

    public DistrictResponse getDistricts(int stateId) {
        Response response = RestAssured.given().pathParam("state_id", String.valueOf(stateId)).contentType(ContentType.JSON).get(EndPoints.GET_DISTRICTS_FOR_A_STATE).andReturn();

        DistrictResponse districtResponse = response.getBody().as(DistrictResponse.class);

        return districtResponse;
    }

    public SessionResponse getHospitalsOfADistrict(int districtId, Date date) {
        Response response = RestAssured.given().queryParam("district_id", String.valueOf(districtId)).queryParam("date", new SimpleDateFormat("dd/MM/yyyy").format(date)).contentType(ContentType.JSON).get(EndPoints.GET_ALL_HOSPITALS_FOR_A_DISTRICT).andReturn();

        SessionResponse sessionResponse = response.getBody().as(SessionResponse.class);

        return sessionResponse;
    }
}
