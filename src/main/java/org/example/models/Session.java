package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Session {
    @Getter @Setter
    private int center_id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private String state_name;
    @Getter @Setter
    private String district_name;
    @Getter @Setter
    private String block_name;
    @Getter @Setter
    private int pincode;
    @Getter @Setter
    private String from;
    @Getter @Setter
    @JsonProperty("to")
    private String myto;
    @Getter @Setter
    private int lat;
    @Getter @Setter
    @JsonProperty("long")
    private int mylong;
    @Getter @Setter
    private String fee_type;
    @Getter @Setter
    private String session_id;
    @Getter @Setter
    private String date;
    @Getter @Setter
    private int available_capacity;
    @Getter @Setter
    private int available_capacity_dose1;
    @Getter @Setter
    private int available_capacity_dose2;
    @Getter @Setter
    private String fee;
    @Getter @Setter
    private boolean allow_all_age;
    @Getter @Setter
    private int min_age_limit;
    @Getter @Setter
    private int max_age_limit;
    @Getter @Setter
    private String vaccine;
    @Getter @Setter
    private ArrayList<Slot> slots;
}