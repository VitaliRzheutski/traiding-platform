package com.vitali.service;

import com.vitali.modal.Coin;
import java.util.List;

public interface CoinService {

    List<Coin> getCoinList(int page) throws Exception;
    String getMarketChart(String coinId, int days) throws Exception;

    String getCoinDetails(String coinId);

    Coin findById(String coinId);//from database

    String searchCoin(String keyword);

    String getTop50CoinsByMarketCapRank();

    String getTreadingCoins();



}
