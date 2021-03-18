package com.example.world.controllers;

import com.example.world.dto.CountryDto;
import com.example.world.exceptions.custom.NotFoundException;
import com.example.world.logger.WorldLogger;
import com.example.world.services.WorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class WorldController {
    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping(value = {"country/{countryCode}","country/{countryCode}/"})
    public ResponseEntity<?> getCountryByCode(@PathVariable String countryCode) throws Exception {
        WorldLogger.log.info("Enter getCountryByCode method of WorldController class");
        CountryDto countryDto = worldService.getCountryByCode(countryCode.toUpperCase());
        WorldLogger.log.info("Exit getCountryByCode method of WorldController class");
        return ResponseEntity.ok(countryDto);

    }

    @GetMapping( value = {"all/get-all-countries","all/get-all-countries/"})
    public ResponseEntity<?> getAllCountry() throws Exception {
        WorldLogger.log.info("Enter getAllCountry method of WorldController class");
        List<CountryDto> countryDtoList = worldService.getAllCountry();
        WorldLogger.log.info("Exit getAllCountry method of WorldController class");
        return ResponseEntity.ok(countryDtoList);
    }
}
