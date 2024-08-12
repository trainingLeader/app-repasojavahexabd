package com.repasojava;


import com.repasojava.Pais.infrastructure.controller.PaisController;

public class Main {
    public static void main(String[] args) {

        PaisController consoleAdapter = new PaisController();

        consoleAdapter.findCountry();


        //consoleAdapter.addCountry();

    }
}