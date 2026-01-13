package com.bschoolland;

import com.bschoolland.services.StoreFront;

public class Main {
    public static void main(String[] args) {
        StoreFront store = new StoreFront();
        StartingActions startingActions = new StartingActions();
        startingActions.start(store);
    }   
}