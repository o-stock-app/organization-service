package com.optimagrowth.organizationservice.controller;

import com.optimagrowth.organizationservice.model.Organization;
import com.optimagrowth.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("optima/v1/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService service;

    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOrganization( @PathVariable("organizationId") UUID organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Organization>> getOrganization() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/bootstrap")
    public ResponseEntity<List<Organization>> getBootstappedOrgs() {
        return ResponseEntity.ok(service.findBtsLicences());
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization( @PathVariable("organizationId") String UUID, @RequestBody Organization organization) {
        service.update(organization);
    }

    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(service.create(organization));
    }

    @DeleteMapping(value="/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("id") String id, @RequestBody Organization organization) {
        service.delete(organization);
    }
}