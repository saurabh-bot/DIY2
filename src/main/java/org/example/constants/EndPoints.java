package org.example.constants;

public class EndPoints {
    public final static String GET_ALL_STATES = "/admin/location/states";
    public final static String GET_DISTRICTS_FOR_A_STATE = "/admin/location/districts/{state_id}";

    public final static String GET_ALL_HOSPITALS_FOR_A_DISTRICT = "/appointment/sessions/public/findByDistrict";
}
