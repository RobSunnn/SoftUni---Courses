package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.entity.OfferEntity;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;


@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        OfferEntity offerEntity = mapOffer(createOfferDTO);

        this.offerRepository.save(offerEntity);

        return offerEntity.getUuid();
    }

    private OfferEntity mapOffer(CreateOfferDTO createOfferDTO) {
        OfferEntity offerEntity = new OfferEntity();

        offerEntity.setUuid(UUID.randomUUID());
        offerEntity.setCreated(LocalDate.now());
        offerEntity.setModel(createOfferDTO.getModel());
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
