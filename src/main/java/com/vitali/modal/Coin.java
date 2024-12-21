package com.vitali.modal;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Coin {

    @Id
    @JsonProperty("id")
    private String id;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public int getMarketCapRank() {
        return marketCapRank;
    }

    public void setMarketCapRank(int marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    public BigDecimal getFullyDilutedValuation() {
        return fullyDilutedValuation;
    }

    public void setFullyDilutedValuation(BigDecimal fullyDilutedValuation) {
        this.fullyDilutedValuation = fullyDilutedValuation;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(BigDecimal totalVolume) {
        this.totalVolume = totalVolume;
    }

    public BigDecimal getHigh24h() {
        return high24h;
    }

    public void setHigh24h(BigDecimal high24h) {
        this.high24h = high24h;
    }

    public BigDecimal getLow24h() {
        return low24h;
    }

    public void setLow24h(BigDecimal low24h) {
        this.low24h = low24h;
    }

    public BigDecimal getPriceChange24h() {
        return priceChange24h;
    }

    public void setPriceChange24h(BigDecimal priceChange24h) {
        this.priceChange24h = priceChange24h;
    }

    public BigDecimal getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    public void setPriceChangePercentage24h(BigDecimal priceChangePercentage24h) {
        this.priceChangePercentage24h = priceChangePercentage24h;
    }

    public BigDecimal getMarketCapChange24h() {
        return marketCapChange24h;
    }

    public void setMarketCapChange24h(BigDecimal marketCapChange24h) {
        this.marketCapChange24h = marketCapChange24h;
    }

    public BigDecimal getMarketCapChangePercentage24h() {
        return marketCapChangePercentage24h;
    }

    public void setMarketCapChangePercentage24h(BigDecimal marketCapChangePercentage24h) {
        this.marketCapChangePercentage24h = marketCapChangePercentage24h;
    }

    public BigDecimal getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(BigDecimal circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public BigDecimal getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(BigDecimal totalSupply) {
        this.totalSupply = totalSupply;
    }

    public BigDecimal getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(BigDecimal maxSupply) {
        this.maxSupply = maxSupply;
    }

    public BigDecimal getAth() {
        return ath;
    }

    public void setAth(BigDecimal ath) {
        this.ath = ath;
    }

    public BigDecimal getAthChangePercentage() {
        return athChangePercentage;
    }

    public void setAthChangePercentage(BigDecimal athChangePercentage) {
        this.athChangePercentage = athChangePercentage;
    }

    public LocalDateTime getAthDate() {
        return athDate;
    }

    public void setAthDate(LocalDateTime athDate) {
        this.athDate = athDate;
    }

    public BigDecimal getAtl() {
        return atl;
    }

    public void setAtl(BigDecimal atl) {
        this.atl = atl;
    }

    public BigDecimal getAtlChangePercentage() {
        return atlChangePercentage;
    }

    public void setAtlChangePercentage(BigDecimal atlChangePercentage) {
        this.atlChangePercentage = atlChangePercentage;
    }

    public LocalDateTime getAtlDate() {
        return atlDate;
    }

    public void setAtlDate(LocalDateTime atlDate) {
        this.atlDate = atlDate;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Column(nullable = false)
    @JsonProperty("symbol")
    private String symbol;

    @Column(nullable = false)
    @JsonProperty("name")
    private String name;

    @JsonProperty("image")
    private String imageUrl;

    @JsonProperty("current_price")
    private BigDecimal currentPrice;

    @JsonProperty("market_cap")
    private BigDecimal marketCap;

    @JsonProperty("market_cap_rank")
    private int marketCapRank;

    @JsonProperty("fully_diluted_valuation")
    private BigDecimal fullyDilutedValuation;

    @JsonProperty("total_volume")
    private BigDecimal totalVolume;

    @JsonProperty("high_24h")
    private BigDecimal high24h;

    @JsonProperty("low_24h")
    private BigDecimal low24h;

    @JsonProperty("price_change_24h")
    private BigDecimal priceChange24h;

    @JsonProperty("price_change_percentage_24h")
    private BigDecimal priceChangePercentage24h;

    @JsonProperty("market_cap_change_24h")
    private BigDecimal marketCapChange24h;

    @JsonProperty("market_cap_change_percentage_24h")
    private BigDecimal marketCapChangePercentage24h;

    @JsonProperty("circulating_supply")
    private BigDecimal circulatingSupply;

    @JsonProperty("total_supply")
    private BigDecimal totalSupply;

    @JsonProperty("max_supply")
    private BigDecimal maxSupply;

    @JsonProperty("ath")
    private BigDecimal ath;

    @JsonProperty("ath_change_percentage")
    private BigDecimal athChangePercentage;

    @JsonProperty("ath_date")
    private LocalDateTime athDate;

    @JsonProperty("atl")
    private BigDecimal atl;

    @JsonProperty("atl_change_percentage")
    private BigDecimal atlChangePercentage;

    @JsonProperty("atl_date")
    private LocalDateTime atlDate;

    @JsonProperty("roi")
    private BigDecimal roi;

    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}