package org.example.models;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

public class DistrictResponse {
    @Getter @Setter
    private ArrayList<District> districts;
    @Getter @Setter
    private int ttl;
}
