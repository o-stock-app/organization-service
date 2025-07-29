package com.optimagrowth.organizationservice;

import com.optimagrowth.organizationservice.model.Organization;
import com.optimagrowth.organizationservice.repository.OrganizationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(OrganizationRepository repo) {
		return args -> {
			List<Organization> orgs = List.of(
					build("Stellar Finance", "Adaeze Eze", "adaeze@stellarfin.com", "+2347011111111"),
					build("KoraTech", "Uche Okeke", "uche@koratech.io", "+2347011111112"),
					build("AgroPulse", "Chuka Nwankwo", "chuka@agropulse.ng", "+2347011111113"),
					build("BlueGrid Energy", "Bisi Alabi", "bisi@bluegrid.com", "+2347011111114"),
					build("SwiftLearn", "Nnenna Obi", "nnenna@swiftlearn.africa", "+2347011111115"),
					build("Verve Legal", "Tunde Bakare", "tunde@vervelegal.ng", "+2347011111116"),
					build("PulseCare Health", "Ifeanyi Duru", "ifeanyi@pulsecare.com", "+2347011111117"),
					build("NovaForge", "Zainab Bello", "zainab@novaforge.io", "+2347011111118"),
					build("Optix Media", "Emeka Obi", "emeka@optixmedia.tv", "+2347011111119"),
					build("GreenRise Farms", "Ruth Audu", "ruth@greenrise.org", "+2347011111120")
			);
			repo.saveAll(orgs);
		};
	}

	private Organization build(String name, String contact, String email, String phone) {
		Organization org = new Organization();
		org.setName(name);
		org.setContactName(contact);
		org.setContactEmail(email);
		org.setContactPhone(phone);
		return org;
	}
}
