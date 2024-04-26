package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.ModelsDTO;

import java.util.List;

public interface ModelService {

    List<ModelsDTO> getAllByBrandId(Long id);

}
