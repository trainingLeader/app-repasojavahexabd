package com.repasojava.Pais.infrastructure.controller;

import com.repasojava.Pais.application.CreatePaisUseCase;
import com.repasojava.Pais.application.FindPaisUseCase;
import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;
import com.repasojava.Pais.infrastructure.repository.PaisRepository;

import java.text.*;
import java.util.*;

public class PaisController {
    private PaisService paisService;
    private CreatePaisUseCase createPaisUseCase;
    private  FindPaisUseCase findPaisUseCase;

    public PaisController() {
        this.paisService = new PaisRepository();
        this.createPaisUseCase = new CreatePaisUseCase(paisService);
        this.findPaisUseCase = new FindPaisUseCase(paisService);
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
    public void findCountry() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter country Id: ");
            Long id = scanner.nextLong();
            findPaisUseCase.execute(id).ifPresentOrElse(
                countryFound -> {
                        System.out.println("Esta es la del pais");
                        System.out.println(MessageFormat.format( "{0}",countryFound.getName()));
                    },
                    () -> {
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
