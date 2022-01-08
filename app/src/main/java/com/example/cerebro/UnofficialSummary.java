package com.example.cerebro;

public class UnofficialSummary {
    public String source;
    public int total;
    public int recovered;
    public int deaths;
    public int active;

    public UnofficialSummary() {
    }

    public UnofficialSummary(String source, int total, int recovered, int deaths, int active) {
        this.source = source;
        this.total = total;
        this.recovered = recovered;
        this.deaths = deaths;
        this.active = active;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
