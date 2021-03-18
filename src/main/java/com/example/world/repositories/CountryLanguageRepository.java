package com.example.world.repositories;

import com.example.world.models.Country;
import com.example.world.models.CountryLanguage;
import com.example.world.models.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
    List<CountryLanguage> findByCountryLanguageId_CountryCode(Country country);
}
