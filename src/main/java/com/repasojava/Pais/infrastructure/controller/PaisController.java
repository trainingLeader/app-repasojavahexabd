package com.repasojava.Pais.infrastructure.controller;

import com.repasojava.Pais.application.CreatePaisUseCase;
import com.repasojava.Pais.domain.entity.Pais;

import java.util.*;

public class PaisController {
    private  CreatePaisUseCase createPaisUseCase;

    public PaisController(CreatePaisUseCase createUserUseCase) {
        this.createPaisUseCase = createUserUseCase;
    }

    public void addCountry() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter country name: ");
            String name = scanner.nextLine();

            Pais pais = new Pais();
            pais.setName(name);

            createPaisUseCase.execute(pais);
        }

        System.out.println("Country created successfully!");
    }
}
