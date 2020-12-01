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
    private double surfaceArea;

    @Column(name = "indep_year")
    private int indepYear;

    @Column(name = "population")
    private int population;

    @Column(name = "life_expectancy")
    private double lifeExpectancy;

    @Column(name = "gnp")
    private double gnp;

    @Column(name = "gnp_old")
    private double gnpOld;

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

    public Country(String name, String continent, String region, double surfaceArea, int indepYear, int population, double lifeExpectancy, double gnp, double gnpOld, String localName, String governmentForm, String headOfState, City capital, String code2) {
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

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(double gnpOld) {
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
