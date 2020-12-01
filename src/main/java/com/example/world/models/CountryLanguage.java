package com.example.world.models;

import javax.persistence.*;

@Entity
@Table(name = "country_language", schema = "public")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId countryLanguageId;

    @Column(name = "is_official")
    private boolean isOfficial;

    @Column(name = "percentage")
    private double percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguageId countryLanguageId, boolean isOfficial, double percentage) {
        this.countryLanguageId = countryLanguageId;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public CountryLanguageId getCountryLanguageId() {
        return countryLanguageId;
    }

    public void setCountryLanguageId(CountryLanguageId countryLanguageId) {
        this.countryLanguageId = countryLanguageId;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}
