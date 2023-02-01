package org.example.models;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

public class StateResponse {
    @Getter @Setter
    private ArrayList<State> states;
    @Getter @Setter
    private int ttl;
}

