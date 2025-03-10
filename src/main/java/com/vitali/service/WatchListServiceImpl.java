package com.vitali.service;

import com.vitali.modal.Coin;
import com.vitali.modal.User;
import com.vitali.modal.WatchList;
import com.vitali.repository.UserRepository;
import com.vitali.repository.WatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchListServiceImpl implements WatchListService {

    @Autowired
    private WatchListRepository watchListRepository;
    @Autowired
    private UserRepository userRepository;

//    @Override
//    public WatchList findUserWatchList(Long userId) throws Exception {
//        System.out.println("userId:" + userId);
//        WatchList watchList = watchListRepository.findByUserId(userId);
//        System.out.println("?watchList" + watchList); //null
//        if(watchList == null){
//            throw new Exception("WatchList not found");
//        }
//        return watchList;
//    }

    @Override
    public WatchList findUserWatchList(Long userId) throws Exception {
        // Check if the user exists
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new Exception("User not found");
        }

        // Find the WatchList associated with the user
        WatchList watchList = watchListRepository.findByUserId(userId);

        // If no WatchList exists for the user, create one
        if (watchList == null) {
            watchList = createWatchList(userOpt.get());
        }

        return watchList;
    }


    @Override
    public WatchList createWatchList(User user) {
        WatchList watchList = new WatchList();
        watchList.setUser(user);

        return watchListRepository.save(watchList);
    }

    @Override
    public WatchList findById(Long id) throws Exception {
        Optional<WatchList> watchListOptional = watchListRepository.findById(id);
        if(watchListOptional.isEmpty()){
            throw new Exception("WatchList not found");
        }

        return watchListOptional.get();
    }

    @Override
    public Coin addItemToWatchlist(Coin coin, User user) throws Exception {
        WatchList watchList = findUserWatchList(user.getId());

        if(watchList.getCoins().contains(coin)){
            watchList.getCoins().remove(coin);
        }else  watchList.getCoins().add(coin);

        watchListRepository.save(watchList);
        return coin;
    }
}
