package com.example.world.services;

import com.example.world.dto.CountryDto;
import com.example.world.exceptions.custom.NotFoundException;
import com.example.world.models.City;
import com.example.world.models.Country;
import com.example.world.models.CountryLanguage;
import com.example.world.models.CountryLanguageId;
import com.example.world.repositories.CountryLanguageRepository;
import com.example.world.repositories.CountryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class WorldServiceTest {
    @Mock
    CountryRepository countryRepository;
    @Mock
    CountryLanguageRepository countryLanguageRepository;
    @InjectMocks
    WorldService worldService;
    private Country country;
    private CountryLanguage countryLanguage;
    private City city;
    private List<CountryLanguage> countryLanguagesList = new ArrayList<>();

    @Before
    public void init() {
        city = new City();
        city.setId(149);
        city.setName("al-Manama");
        city.setDistrict("al-Manama");
        city.setPopulation(148000);
        country = new Country();
        country.setCode("BHR");
        country.setName("Bahrain");
        country.setContinent("Asia");
        country.setRegion("Middle East");
        country.setSurfaceArea(694F);
        country.setIndepYear(1971);
        country.setPopulation(617000);
        country.setLifeExpectancy(73F);
        country.setGnp(6366.00);
        country.setGnpOld(6097.00);
        country.setLocalName("Al-Bahrayn");
        country.setGovernmentForm("Monarchy (Emirate)");
        country.setHeadOfState("Hamad ibn Isa al-Khalifa");
        city.setCountryCode(country);
        country.setCapital(city);
        country.setCode2("BH");
        countryLanguage = new CountryLanguage();
        countryLanguage.setCountryLanguageId(new CountryLanguageId(country, "Arabic"));
        countryLanguage.setOfficial(true);
        countryLanguage.setPercentage((float) 67.699997);
        countryLanguagesList.add(countryLanguage);
    }

    @Test(expected = NotFoundException.class)
    public void getCountryByCodeTest1() throws Exception {
        Mockito.when(countryRepository.findByCode("BHR")).
                thenReturn(null);
        CountryDto countryDto = worldService.getCountryByCode("BHR");
    }


    @Test(expected = Exception.class)
    public void getCountryByCodeTest2() throws Exception {
        Mockito.when(countryRepository.findByCode("BHR")).
                thenReturn(country);
        Mockito.when(countryLanguageRepository
                .findByCountryLanguageId_CountryCode(country)).thenReturn(null);
        CountryDto countryDto = worldService.getCountryByCode("BHR");

    }

    @Test
    public void getCountryByCodeTest3() throws Exception {
        Mockito.when(countryRepository.findByCode("BHR")).
                thenReturn(country);
        Mockito.when(countryLanguageRepository
                .findByCountryLanguageId_CountryCode(country)).thenReturn(countryLanguagesList);
        CountryDto countryDto = worldService.getCountryByCode("BHR");
        Assert.assertEquals(countryDto.getName(), country.getName());
        Assert.assertEquals(countryDto.getContinent(), country.getContinent());
        Assert.assertEquals(countryDto.getPopulation(), country.getPopulation());
        Assert.assertEquals(countryDto.getLifeExpectancy(), country.getLifeExpectancy(), 0.0);
        Assert.assertEquals(countryDto.getLanguage(), countryLanguage.getCountryLanguageId().getLanguage());
    }

    @Test(expected = Exception.class)
    public void getCountryByCodeTest4() throws Exception {
        Mockito.when(countryRepository.findByCode("BHR")).
                thenThrow(new Exception());
        Mockito.when(countryLanguageRepository.findByCountryLanguageId_CountryCode(country)).thenReturn(countryLanguagesList);
        CountryDto countryDto = worldService.getCountryByCode("BHR");
    }

    @Test(expected = Exception.class)
    public void getCountryByCodeTest5() throws Exception {
        Mockito.when(countryRepository.findByCode("BHR")).
                thenReturn(country);
        Mockito.when(countryLanguageRepository.findByCountryLanguageId_CountryCode(country)).thenThrow(new Exception());
        CountryDto countryDto = worldService.getCountryByCode("BHR");
    }
}