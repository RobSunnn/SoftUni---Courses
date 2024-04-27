package org.softuni.mobilele.model.dto;

import java.util.List;

public class BrandDTO {

    private String brandName;

    private List<ModelsDTO> models;

    public BrandDTO() {}

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ModelsDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelsDTO> models) {
        this.models = models;
    }
}
