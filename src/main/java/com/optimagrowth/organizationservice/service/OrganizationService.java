package com.optimagrowth.organizationservice.service;

import com.optimagrowth.organizationservice.model.Organization;
import com.optimagrowth.organizationservice.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private static final Logger log = LoggerFactory.getLogger(OrganizationService.class);
    private final OrganizationRepository orgRepo;

    public Organization findById(UUID organizationId) {
        Optional<Organization> opt = orgRepo.findById(organizationId);

        if (opt.isPresent())
            return opt.get();
        else
            log.warn("Organization with id: {} not found", organizationId);

        return null;
    }

    public List<Organization> findAll() {
        return orgRepo.findAll();
    }

    public Organization create(Organization organization){
        organization.setId(UUID.randomUUID());
        organization = orgRepo.save(organization);
        return organization;
    }

    public void update(Organization organization){
        orgRepo.save(organization);
    }

    public void delete(Organization organization){
        orgRepo.deleteById(organization.getId());
    }


    public List<Organization> findBtsLicences() {
        List<Organization> existingLicenses = orgRepo.findAll();

        if (existingLicenses != null)
            return existingLicenses;

        List<Organization> orgs = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            String uniqueSuffix = UUID.randomUUID().toString().substring(0, 8);

            Organization org = Organization.builder()
                    .name("Org-" + uniqueSuffix)
                    .contactName("Contact " + i)
                    .contactEmail("contact" + uniqueSuffix + "@example.com")
                    .contactPhone("080" + String.format("%08d", i))
                    .build();
            orgs.add(org);
            orgRepo.saveAll(orgs);
            log.info("all orgs saved");
        }
        log.info("all orgs returned");
        return orgs;
    }

}