package org.assign8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Author {
    private String name;
    private String lastname;
    private String country;
    private List<String> originCountry =new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Author(String name, String lastname, String country, List<String> originCountry) {

        this.name = name;
        this.lastname = lastname;
        this.country = country;
        this.originCountry = originCountry;

    }

    public Author() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Author [name=" + name + ", lastname=" + lastname + ", country="
                + country + "]";
    }

    public static List <String> getOriginCountry(Author author) {
        return Arrays.asList();
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }
};
