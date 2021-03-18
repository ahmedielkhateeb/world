package com.example.world.services;

import com.example.world.dto.CountryDto;
import com.example.world.exceptions.custom.NotFoundException;
import com.example.world.logger.WorldLogger;
import com.example.world.models.Country;
import com.example.world.models.CountryLanguage;
import com.example.world.repositories.CountryLanguageRepository;
import com.example.world.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorldService {
    private final CountryRepository countryRepository;
    private final CountryLanguageRepository countryLanguageRepository;

    @Autowired
    public WorldService(CountryRepository countryRepository, CountryLanguageRepository countryLanguageRepository) {

        this.countryRepository = countryRepository;
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public CountryDto getCountryByCode(String countryCode) throws Exception {
        WorldLogger.log.info("Enter getCountryByCode method of WorldService class");
        CountryDto countryDto = new CountryDto();
        try {
            Country country = countryRepository.findByCode(countryCode);
            if (country == null) {
                WorldLogger.log.error("Error in getCountryByCode method of WorldService class");
                WorldLogger.log.error("No country with code " + countryCode);
                throw new NotFoundException("INVALID_COUNTRY_CODE");
            }
            List<CountryLanguage> countryLanguageList = countryLanguageRepository
                    .findByCountryLanguageId_CountryCode(country);
            if (!countryLanguageList.isEmpty()) {
                CountryLanguage countryLanguage = countryLanguageList.get(0);
                if (countryLanguage == null) {
                    WorldLogger.log.error("Error in getCountryByCode method of WorldService class");
                    WorldLogger.log.error("No country language with code " + countryCode);
                    throw new NotFoundException("INVALID_COUNTRY_CODE");
                }
                WorldLogger.log.info("Exit getCountryByCode method of WorldService class");
                countryDto.setName(country.getName());
                countryDto.setContinent(country.getContinent());
                countryDto.setPopulation(country.getPopulation());
                countryDto.setLifeExpectancy(country.getLifeExpectancy());
                countryDto.setLanguage(countryLanguage.getCountryLanguageId().getLanguage());
            }
            return countryDto;
        } catch (Exception exception) {
            if (exception.getMessage().equals("INVALID_COUNTRY_CODE")) {
                throw new NotFoundException("INVALID_COUNTRY_CODE");
            } else {
                WorldLogger.log.error("Error in getCountryByCode method of WorldService class");
                WorldLogger.log.error("Database Error");
                throw new Exception();
            }
        }
    }

    public ArrayList<CountryDto> getAllCountry() throws Exception {
        WorldLogger.log.info("Enter getAllCountry method of WorldService class");
        ArrayList<CountryDto> countriesList = new ArrayList<>();
        try {
            List<Country> countries = countryRepository.findAll();
            if (countries.isEmpty()) {
                WorldLogger.log.error("Error in getAllCountry method of WorldService class");
                WorldLogger.log.error("No Countries Found");
                throw new Exception("NO_COUNTIES_FOUND");
            }
            for (Country country : countries) {
                List<CountryLanguage> countryLanguageList = countryLanguageRepository
                        .findByCountryLanguageId_CountryCode(country);
                if (!countryLanguageList.isEmpty()) {
                    CountryLanguage countryLanguage = countryLanguageList.get(0);
                    if (countryLanguage == null) {
                        WorldLogger.log.error("Error in getAllCountry method of WorldService class");
                        WorldLogger.log.error("No Country language Found for the country code " + country.getCode());
                        throw new NotFoundException("INVALID_COUNTRY_CODE");
                    }
                    countriesList.add(new CountryDto(country.getName(),
                            country.getContinent(), country.getPopulation(),
                            country.getLifeExpectancy(),
                            countryLanguage.getCountryLanguageId().getLanguage()));
                }
            }
            WorldLogger.log.info("Exit getAllCountry method of WorldService class");
            return countriesList;
        } catch (Exception exception) {
            if (exception.getMessage().equals("NO_COUNTIES_FOUND")) {
                throw new Exception("NO_COUNTIES_FOUND");
            } else if (exception.getMessage().equals("INVALID_COUNTRY_CODE")) {
                throw new NotFoundException("INVALID_COUNTRY_CODE");
            } else {
                WorldLogger.log.error("Error in getAllCountry method of WorldService class");
                WorldLogger.log.error("Database Error");
                System.err.println(exception.getMessage());
                throw new Exception();
            }

        }
    }

}
