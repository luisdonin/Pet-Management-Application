package com.example.pets.model;

import java.io.Serializable;
/*
* May 26th, 2025
*  This class represents a pet species with its binomial nomenclature.
*  Before setting the breed I need to set the species
*  "The binomial nomenclature is a formal system of naming species of living things" - Wikipedia
*  Because I get my false data from real people, not AI
*
* */
public class Species implements Serializable {
    String BinomialNomenclature;

    public Species(String binomialNomenclature) {
        this.BinomialNomenclature = binomialNomenclature;
    }

    public String getBinomialNomenclature() {
        return BinomialNomenclature;
    }

    public void setBinomialNomenclature(String binomialNomenclature) {
        BinomialNomenclature = binomialNomenclature;
    }
}
