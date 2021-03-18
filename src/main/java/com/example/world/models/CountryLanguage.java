package com.example.world.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "country_language", schema = "public")
public class CountryLanguage {

    @EmbeddedId
    @NotNull
    private CountryLanguageId countryLanguageId;

    @Column(name = "is_official")
    @NotNull
    private boolean isOfficial;

    @Column(name = "percentage")
    @NotNull
    private Float percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguageId countryLanguageId, boolean isOfficial, Float percentage) {
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

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

}
