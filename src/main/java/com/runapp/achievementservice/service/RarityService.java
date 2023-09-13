package com.runapp.achievementservice.service;

import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.repository.RarityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RarityService {
    private final RarityRepository rarityRepository;

    @Autowired
    public RarityService(RarityRepository rarityRepository) {
        this.rarityRepository = rarityRepository;
    }

    public RarityModel createRarity(RarityModel rarityModel) {
        return rarityRepository.save(rarityModel);
    }

    public Optional<RarityModel> getRarityById(int id) {
        return rarityRepository.findById(id);
    }

    public RarityModel updateRarity(RarityModel rarityModel) {
        return rarityRepository.save(rarityModel);
    }

    public void deleteRarity(int id) {
        rarityRepository.deleteById(id);
    }

    public List<RarityModel> getAllRarities() {
        return rarityRepository.findAll();
    }
}
