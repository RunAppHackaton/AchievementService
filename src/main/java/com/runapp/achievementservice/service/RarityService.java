package com.runapp.achievementservice.service;

import com.runapp.achievementservice.exception.NoEntityFoundException;
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
        if (rarityRepository.existsById(rarityModel.getId())) {
            rarityRepository.save(rarityModel);
        } else {
            throw new NoEntityFoundException("Rarity not found with id: " + rarityModel.getId());
        }

        return rarityRepository.save(rarityModel);
    }

    public void deleteRarity(int id) {
        if (rarityRepository.existsById(id)) {
            rarityRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Rarity not found with id: " + id);
        }
    }

    public List<RarityModel> getAllRarities() {
        return rarityRepository.findAll();
    }
}
