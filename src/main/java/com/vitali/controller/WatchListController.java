package com.vitali.controller;

import com.vitali.modal.Coin;
import com.vitali.modal.User;
import com.vitali.modal.WatchList;
import com.vitali.service.CoinService;
import com.vitali.service.UserService;
import com.vitali.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watchlist")
public class WatchListController {
    @Autowired
    private  WatchListService watchListService;
    @Autowired
    private  UserService userService;

    @Autowired
    private CoinService coinService;

    @GetMapping("/user")
    public ResponseEntity<WatchList>getUserWatchList(
            @RequestHeader("Authorization")String jwt) throws Exception{
        User user = userService.findUserByJwt(jwt);
        WatchList watchList = watchListService.findUserWatchList(user.getId());
        return ResponseEntity.ok(watchList);
    }

    @GetMapping("/{watchlistId}")
    public ResponseEntity<WatchList>getWatchListById(
            @PathVariable Long watchlistId
    ) throws Exception{
        WatchList watchList = watchListService.findById(watchlistId);
        return ResponseEntity.ok(watchList);
    }

    @PatchMapping("/add/coin/{coinId}")
    public ResponseEntity<Coin>addItemToWatchlist(
            @RequestHeader("Authorization")String jwt,
            @PathVariable String coinId
            ) throws Exception{
        User user = userService.findUserByJwt(jwt);
        Coin coin = coinService.findById(coinId);
        Coin addedCoin = watchListService.addItemToWatchlist(coin, user);
        return ResponseEntity.ok(addedCoin);
    }



}
