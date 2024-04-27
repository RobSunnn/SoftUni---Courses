package org.softuni.mobilele.model.dto;

import org.softuni.mobilele.model.entity.enums.EngineEnum;
import org.softuni.mobilele.model.entity.enums.TransmissionEnum;

import java.math.BigDecimal;

public record OfferDetailDTO(
    String id,
    String brand,
    String model,
    int year,
    Long mileage,
    BigDecimal price,
    EngineEnum engine,
    TransmissionEnum transmission,
    String imageUrl,
    String seller,
    boolean viewerIsOwner
) {
  public String summary() {
    return brand + " " + model + ", " + year;
  }
}