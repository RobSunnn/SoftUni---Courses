package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.model.entity.enums.EngineEnum;
import org.softuni.mobilele.model.entity.enums.TransmissionEnum;

import java.math.BigDecimal;

public class CreateOfferDTO {

    @NotNull
    private Long modelId;

    @Size(min = 2, max = 150)
    private String description;

    @NotNull
    private EngineEnum engine;

    @NotBlank
    private String imageUrl;

    @NotNull
    @Positive
    private Long mileage;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private TransmissionEnum transmission;

    @NotNull
    @Positive
    private Integer year;

    public CreateOfferDTO() {}

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
