package com.vitali.service;

import com.vitali.modal.Asset;
import com.vitali.modal.Coin;
import com.vitali.modal.User;

import java.util.List;

public interface AssetService {

    Asset createAsset(User user, Coin coin, double quantity);
    Asset getAssetById(long id) throws Exception;
    Asset getAssetByUserId(Long userId, long assetId);

    List<Asset> getUsersAssets(Long userId);
    List<Asset> getAllAssets();

    Asset updateAsset(Long assetId, double quantity) throws Exception;

    Asset findAssetByUserIdAndCoinId(Long userId, String coinId);
    void deleteAsset(Long assetIdl);

}
