package com.vitali.service;

import com.vitali.modal.Coin;

import java.util.List;

public class CoinServiceImpl implements CoinService {
    @Override
    public List<Coin> getCoinList(int page) {
        return List.of();
    }

    @Override
    public String getMarketChart(String coinId, int days) {
        return "";
    }

    @Override
    public String getCoinDetails(String coinId) {
        return "";
    }

    @Override
    public Coin findById(String coinId) {
        return null;
    }

    @Override
    public String searchCoin(String keyword) {
        return "";
    }

    @Override
    public String getTop50CoinsByMarketCapRank() {
        return "";
    }

    @Override
    public String getTreadingCoins() {
        return "";
    }

}
