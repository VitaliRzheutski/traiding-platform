package com.vitali.service;

import com.vitali.modal.Coin;
import com.vitali.modal.User;
import com.vitali.modal.WatchList;


public interface WatchListService {

    WatchList findUserWatchList(Long userId) throws Exception;

    WatchList createWatchList(User user);

    WatchList findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;



}
