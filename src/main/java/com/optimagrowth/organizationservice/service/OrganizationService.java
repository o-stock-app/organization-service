package com.optimagrowth.organizationservice.service;

import com.optimagrowth.organizationservice.model.Organization;
import com.optimagrowth.organizationservice.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}