package com.wdharmana.coinmonitor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rate {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("asset_id_quote")
    @Expose
    private String assetIdQuote;
    @SerializedName("rate")
    @Expose
    private Double rate;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAssetIdQuote() {
        return assetIdQuote;
    }

    public void setAssetIdQuote(String assetIdQuote) {
        this.assetIdQuote = assetIdQuote;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
