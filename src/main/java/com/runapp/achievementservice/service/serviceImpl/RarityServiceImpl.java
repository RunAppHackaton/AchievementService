package com.runapp.achievementservice.service.serviceImpl;

import com.runapp.achievementservice.exception.NoEntityFoundException;
import com.runapp.achievementservice.model.RarityModel;
import com.runapp.achievementservice.repository.RarityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RarityServiceImpl implements com.runapp.achievementservice.service.RarityService {
    private final RarityRepository rarityRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(RarityServiceImpl.class);

    @Autowired
    public RarityServiceImpl(RarityRepository rarityRepository) {
        this.rarityRepository = rarityRepository;
    }

    @Override
    public RarityModel add(RarityModel entity) {
        LOGGER.info("Rarity add: {}", entity);
        return rarityRepository.save(entity);
    }

    @Override
    public RarityModel getById(Long id) {
        LOGGER.info("Rarity get by id: {}", id);
        return rarityRepository.findById(id)
                .orElseThrow(() -> new NoEntityFoundException("Rarity not found with id: " + id));
    }

    @Override
    public List<RarityModel> getAll() {
        LOGGER.info("Rarity get all");
        return rarityRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("Rarity delete by id: {}", id);
        if (rarityRepository.existsById(id)) {
            rarityRepository.deleteById(id);
        } else {
            throw new NoEntityFoundException("Rarity not found with id: " + id);
        }
    }

    @Override
    public RarityModel update(RarityModel entity) {
        LOGGER.info("Rarity update: {}", entity);
        if (rarityRepository.existsById(entity.getId())) {
            rarityRepository.save(entity);
        } else {
            throw new NoEntityFoundException("Rarity not found with id: " + entity.getId());
        }

        return rarityRepository.save(entity);
    }
}
