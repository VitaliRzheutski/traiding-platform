package com.vitali.service;

import com.vitali.modal.Coin;
import java.util.List;

public interface CoinService {

    List<Coin> getCoinList(int page);
    String getMarketChart(String coinId, int days);

    String getCoinDetails(String coinId);

    Coin findById(String coinId);//from database

    String searchCoin(String keyword);

    String getTop50CoinsByMarketCapRank();

    String getTreadingCoins();



}
