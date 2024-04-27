package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.model.entity.OfferEntity;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;


@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        OfferEntity offerEntity = mapOffer(createOfferDTO);
        ModelEntity model = modelRepository.findById(createOfferDTO.getModelId()).orElseThrow(() ->
                new IllegalArgumentException("Model don't exist"));

        offerEntity.setModel(model);

        this.offerRepository.save(offerEntity);

        return offerEntity.getUuid();
    }

    private OfferEntity mapOffer(CreateOfferDTO createOfferDTO) {
        OfferEntity offerEntity = new OfferEntity();

        offerEntity.setUuid(UUID.randomUUID());
        offerEntity.setCreated(LocalDate.now());
        offerEntity.setPrice(createOfferDTO.getPrice());
        offerEntity.setEngine(createOfferDTO.getEngine());
        offerEntity.setTransmission(createOfferDTO.getTransmission());
        offerEntity.setYear(createOfferDTO.getYear());
        offerEntity.setMileage(createOfferDTO.getMileage());
        offerEntity.setDescription(createOfferDTO.getDescription());
        offerEntity.setImageUrl(createOfferDTO.getImageUrl());

        return offerEntity;
    }
}
