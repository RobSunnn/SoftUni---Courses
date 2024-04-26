package org.softuni.mobilele.model.dto;

import java.util.List;

public class BrandDTO {

    private Long id;
    private String brandName;

    private List<ModelsDTO> models;

    public BrandDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
