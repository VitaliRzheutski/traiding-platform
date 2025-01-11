package com.vitali.service;

import com.vitali.modal.Asset;
import com.vitali.modal.Coin;
import com.vitali.modal.User;
import com.vitali.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset createAsset(User user, Coin coin, double quantity) {
        Asset asset = new Asset();
        asset.setUser(user);
        asset.setCoin(coin);
        asset.setQuantity(quantity);
        asset.setBuyPrice(coin.getCurrentPrice());
        return assetRepository.save(asset);
    }

    @Override
    public Asset getAssetById(long assetId) throws Exception {
        return assetRepository.findById(assetId)
                .orElseThrow(()->new Exception("asset not found"));
    }

    @Override
    public Asset getAssetByUserId(Long userId, long assetId) {
        return null;
    }

    @Override
    public List<Asset> getUsersAssets(Long userId) {
        return assetRepository.findByUserId(userId);
    }
    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }
    @Override
    public Asset updateAsset(Long assetId, double quantity) throws Exception {

        Asset oldAsset=getAssetById(assetId);
        oldAsset.setQuantity(quantity + oldAsset.getQuantity());
        return assetRepository.save(oldAsset);

    }

    @Override
    public Asset findAssetByUserIdAndCoinId(Long userId, String coinId) {
        return assetRepository.findByUserIdAndCoinId(userId,coinId);
    }

    @Override
    public void deleteAsset(Long assetId) {
    assetRepository.deleteById(assetId);
    }
}
