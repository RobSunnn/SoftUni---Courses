package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.ModelsDTO;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<ModelsDTO> getAllByBrandId(Long id) {
        List<ModelEntity> allModels = this.modelRepository.findAllByBrandId(id);
        List<ModelsDTO> allModelsDTO = new ArrayList<>();

        for (ModelEntity model : allModels) {
            allModelsDTO.add(mapModel(model));
        }

        return allModelsDTO;
    }

    public List<ModelsDTO> findAll() {
        List<ModelEntity> allModels = this.modelRepository.findAll();
        List<ModelsDTO> allModelsDTO = new ArrayList<>();

        for (ModelEntity model : allModels) {
            allModelsDTO.add(mapModel(model));
        }

        return allModelsDTO;

    }

    private ModelsDTO mapModel(ModelEntity model) {
        ModelsDTO modelsDTO = new ModelsDTO();

        modelsDTO.setId(model.getId());
        modelsDTO.setModelName(model.getModelName());

        return modelsDTO;
    }
}
