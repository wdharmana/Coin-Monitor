package com.wdharmana.coinmonitor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RateResponse {

    @SerializedName("asset_id_base")
    @Expose
    private String assetIdBase;
    @SerializedName("rates")
    @Expose
    private List<Rate> rates = null;

    public String getAssetIdBase() {
        return assetIdBase;
    }

    public void setAssetIdBase(String assetIdBase) {
        this.assetIdBase = assetIdBase;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
