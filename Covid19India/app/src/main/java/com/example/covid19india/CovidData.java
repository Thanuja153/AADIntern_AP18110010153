package com.example.covid19india;

public class CovidData {
    private String date,active,recovered,deaths;
    public CovidData(String date, String active, String recovered, String deaths) {
        this.date=date;
        this.active=active;
        this.recovered=recovered;
        this.deaths=deaths;
    }

    public String getDate()
    {
        return date;
    }

    public String getActive()
    {
        return active;
    }

    public String getDeaths()
    {
        return deaths;
    }

    public String getRecovered()
    {
        return recovered;
    }

}
