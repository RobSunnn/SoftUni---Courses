package com.plannerapp.init;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrioritiesInit implements CommandLineRunner {

    private final PriorityRepository priorityRepository;

    public PrioritiesInit(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (priorityRepository.count() == 0) {

            for (PriorityName value : PriorityName.values()) {
                PriorityEntity priority = new PriorityEntity();

                String description = switch (value) {

                    case URGENT -> "An urgent problem that blocks the system use until the issue is resolved.";
                    case IMPORTANT ->
                            "A core functionality that your product is explicitly supposed to perform is compromised.";
                    case LOW -> "Should be fixed if time permits but can be postponed.";
                };

                priority.setName(value);
                priority.setDescription(description);

                priorityRepository.save(priority);
            }
        }

    }
}
