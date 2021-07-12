package com.tenants.debugger.tenant;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Tenant {
	@Id
	@Column(nullable = false)
	@SequenceGenerator(name = "tenant_sequence", 
	sequenceName = "tenant_sequence", allocationSize = 1)

	private Long residentialAddress;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@NotBlank
	@Column(nullable = false)
	private String Surnname;
	
	private int numOccupants;
	
	private Date tenantSince;

	public Long getResidentialAddress() {
		return residentialAddress;
	}

	public String getName() {
		return name;
	}

	public String getSurnname() {
		return Surnname;
	}

	public int getNumOccupants() {
		return numOccupants;
	}

	public Date getTenantSince() {
		return tenantSince;
	}

	public void setResidentialAddress(Long residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurnname(String surnname) {
		Surnname = surnname;
	}

	public void setNumOccupants(int numOccupants) {
		this.numOccupants = numOccupants;
	}

	public void setTenantSince(Date tenantSince) {
		this.tenantSince = tenantSince;
	}
	
	
	
	
	

}
