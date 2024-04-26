package org.softuni.mobilele.model.dto;

import org.softuni.mobilele.model.entity.enums.CategoryOfVehicleEnum;

public class ModelsDTO {

    private String modelName;

    private String category;

    private String imageUrl;

    private Long brandId;

    public ModelsDTO() {}

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
