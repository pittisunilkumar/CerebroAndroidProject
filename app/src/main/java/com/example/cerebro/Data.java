package com.example.cerebro;

import java.util.List;

public class Data {
    public Summary summary;
    public List<UnofficialSummary> unofficialSummary;
    public List<Regional> regional;

    public Data() {
    }

    public Data(Summary summary, List<UnofficialSummary> unofficialSummary, List<Regional> regional) {
        this.summary = summary;
        this.unofficialSummary = unofficialSummary;
        this.regional = regional;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<UnofficialSummary> getUnofficialSummary() {
        return unofficialSummary;
    }

    public void setUnofficialSummary(List<UnofficialSummary> unofficialSummary) {
        this.unofficialSummary = unofficialSummary;
    }

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }
}
