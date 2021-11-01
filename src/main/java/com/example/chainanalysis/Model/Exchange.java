package com.example.chainanalysis.Model;

import javax.persistence.*;

@Entity
@Table
public class Exchange {
    @Id
    @SequenceGenerator(
            name = "exchange_sequence",
            sequenceName = "exchange_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exchange_sequence"
    )
    private Long id;
    private String name;
    private String apiURL;

    public Exchange() {}

    public Exchange(Long id, String name, String apiURL) {
        this.id = id;
        this.name = name;
        this.apiURL = apiURL;
    }

    public Exchange(String name, String apiURL) {
        this.name = name;
        this.apiURL = apiURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String API_URL) {
        this.apiURL = API_URL;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", API_URL='" + apiURL + '\'' +
                '}';
    }
}
