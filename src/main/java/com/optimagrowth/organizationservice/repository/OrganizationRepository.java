package com.optimagrowth.organizationservice.repository;

import com.optimagrowth.organizationservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    public Optional<Organization> findById(UUID organizationId);
}