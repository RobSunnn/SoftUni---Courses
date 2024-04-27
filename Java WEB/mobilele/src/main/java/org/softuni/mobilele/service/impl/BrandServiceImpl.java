package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.ModelsDTO;
import org.softuni.mobilele.model.entity.BrandEntity;
import org.softuni.mobilele.repository.BrandRepository;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final ModelService modelService;

    public BrandServiceImpl(BrandRepository brandRepository, ModelService modelService) {
        this.brandRepository = brandRepository;
        this.modelService = modelService;
    }


    @Override
    public List<BrandDTO> getAllBrands() {

        List<BrandEntity> allBrands = this.brandRepository.findAll();
        List<BrandDTO> allBrandsDTO = new ArrayList<>();

        for (BrandEntity brand : allBrands) {
            allBrandsDTO.add(mapBrandToDTO(brand));
        }

        return allBrandsDTO;
    }

    private BrandDTO mapBrandToDTO(BrandEntity brand) {

        BrandDTO brandDTO = new BrandDTO();
        List<ModelsDTO> allModelsByBrandId = this.modelService.getAllByBrandId(brand.getId());

        brandDTO.setBrandName(brand.getBrandName());
        brandDTO.setModels(allModelsByBrandId);

        return brandDTO;
    }
}
