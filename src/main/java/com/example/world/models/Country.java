package com.example.world.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "country", schema = "public",
        indexes = @Index(name = "idx_country_name", columnList = "name", unique = true))
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code")
    @NotNull
    private String code;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "continent")
    @NotNull
    private String continent;

    @Column(name = "region")
    @NotNull
    private String region;

    @Column(name = "surface_area")
    @NotNull
    private Float surfaceArea;

    @Column(name = "indep_year")
    private Integer indepYear;

    @Column(name = "population")
    private Integer population;

    @Column(name = "life_expectancy")
    private Float lifeExpectancy;

    @Column(name = "gnp")
    private Double gnp;

    @Column(name = "gnp_old")
    private Double gnpOld;

    @Column(name = "local_name")
    @NotNull
    private String localName;

    @Column(name = "government_form")
    @NotNull
    private String governmentForm;

    @Column(name = "head_of_state")
    private String headOfState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City capital;

    @Column(name = "code2")
    @NotNull
    private String code2;

    public Country() {
    }

    public Country(String name, String continent, String region, Float surfaceArea, Integer indepYear, Integer population, Float lifeExpectancy, Double gnp, Double gnpOld, String localName, String governmentForm, String headOfState, City capital, String code2) {
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    public Double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String local_name) {
        this.localName = local_name;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
