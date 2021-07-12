package com.tenants.debugger.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenants.debugger.service.TenantService;
import com.tenants.debugger.tenant.Tenant;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/tenants")
@AllArgsConstructor
public class TenantController {

    private TenantService tenantService;

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Tenant tenant) {
    	tenantService.addTenant(tenant);
    }

    @DeleteMapping(path = "{residentialAddress}")
    public void deleteStudent(
            @PathVariable("residentialAddress") Long residentialAddress) {
    	tenantService.deleteTenant(residentialAddress);
    }
}
