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
        ModelEntity model = modelRepository.findById(createOfferDTO.modelId()).orElseThrow(() ->
                new IllegalArgumentException("Model don't exist"));

        offerEntity.setModel(model);

        this.offerRepository.save(offerEntity);

        return offerEntity.getUuid();
    }

    private OfferEntity mapOffer(CreateOfferDTO createOfferDTO) {
        OfferEntity offerEntity = new OfferEntity();

        offerEntity.setUuid(UUID.randomUUID());
        offerEntity.setCreated(LocalDate.now());
        offerEntity.setPrice(createOfferDTO.price());
        offerEntity.setEngine(createOfferDTO.engine());
        offerEntity.setTransmission(createOfferDTO.transmission());
        offerEntity.setYear(createOfferDTO.year());
        offerEntity.setMileage(createOfferDTO.mileage());
        offerEntity.setDescription(createOfferDTO.description());
        offerEntity.setImageUrl(createOfferDTO.imageUrl());

        return offerEntity;
    }
}
