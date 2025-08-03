package com.optimagrowth.organizationservice.service;

import com.optimagrowth.organizationservice.model.Organization;
import com.optimagrowth.organizationservice.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository orgRepo;

    public Organization findById(UUID organizationId) {
        Optional<Organization> opt = orgRepo.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
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
        }
        return orgs;
    }

}