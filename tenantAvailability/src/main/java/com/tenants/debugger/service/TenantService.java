package com.tenants.debugger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenants.debugger.exceptions.BadRequestException;
import com.tenants.debugger.exceptions.TenantNotFoundException;
import com.tenants.debugger.repository.TenantRepository;
import com.tenants.debugger.tenant.Tenant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TenantService {

	private TenantRepository tenantRepository;

	@Autowired
	public TenantService(TenantRepository tenantRepository) {
		this.tenantRepository = tenantRepository;
	}

	public List<Tenant> getAllTenants() {
		return tenantRepository.findAll();
	}

	// add new tenant if the apartment is not occupied

	public void addTenant(Tenant tenant) {
		Boolean isOccupied = tenantRepository.selectByAvailableResidential(tenant.getResidentialAddress());
		if (isOccupied) {
			// == this section too needs to be tested ==
			throw new BadRequestException(
					"residential address: " + tenant.getResidentialAddress() + " has been occupied");
		}

		tenantRepository.save(tenant);
	}

	// Remove a tenant who's moving out 
	public void deleteTenant(Long residentialAddress) {
		if (!tenantRepository.existsById(residentialAddress)) {
			throw new TenantNotFoundException("Tenant at residential address: " + residentialAddress + " does not exists");
		}
		tenantRepository.deleteById(residentialAddress);
	}
}
