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
    private Long id; // id
    private String name; // name of exchange
    private String apiURL; // public api
    private String cryptoNames; // name of cryptos, comma seperated!

    public Exchange() {}

    public Exchange(Long id, String name, String apiURL, String cryptoNames) {
        this.id = id;
        this.name = name;
        this.apiURL = apiURL;
        this.cryptoNames = cryptoNames;
    }

    public Exchange(String name, String apiURL, String cryptoNames) {
        this.name = name;
        this.apiURL = apiURL;
        this.cryptoNames = cryptoNames;
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

    public String getCryptoNames() {
        return cryptoNames;
    }

    public void setCryptoNames(String cryptoNames) {
        this.cryptoNames = cryptoNames;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apiURL='" + apiURL + '\'' +
                ", cryptoNames='" + cryptoNames + '\'' +
                '}';
    }
}
