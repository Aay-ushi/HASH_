package com.example.mani.hash;

/**
 * Created by mani on 3/9/18.
 */

public class Schemes {
    String name,description,eligiblity,benefits;
    String how_to_apply,websites,additional_information;

    public Schemes(String name, String description, String eligiblity, String benefits,
                   String how_to_apply, String websites, String additional_information) {

        this.name = name;
        this.description = description;
        this.eligiblity = eligiblity;
        this.benefits = benefits;
        this.how_to_apply = how_to_apply;
        this.websites = websites;
        this.additional_information = additional_information;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEligiblity() {
        return eligiblity;
    }

    public String getBenefits() {
        return benefits;
    }

    public String getHow_to_apply() {
        return how_to_apply;
    }

    public String getWebsites() {
        return websites;
    }

    public String getAdditional_information() {
        return additional_information;
    }


}
