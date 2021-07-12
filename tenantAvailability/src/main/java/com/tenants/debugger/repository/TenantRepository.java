package com.tenants.debugger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tenants.debugger.tenant.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

	@Query("" + "SELECT CASE WHEN COUNT(s) > 0 THEN " + "TRUE ELSE FALSE END " + "FROM Tenant t "
			+ "WHERE t.residentialAddress = ?1")

	Boolean selectByAvailableResidential(Long residentialAddress);

}
