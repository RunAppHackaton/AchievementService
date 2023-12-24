package com.runapp.achievementservice.service.serviceTemplate;

import java.util.List;

public interface CrudOperations<Model> {
    Model add(Model entity);

    Model getById(Long id);

    List<Model> getAll();

    void deleteById(Long id);

    Model update(Model entity);

}
