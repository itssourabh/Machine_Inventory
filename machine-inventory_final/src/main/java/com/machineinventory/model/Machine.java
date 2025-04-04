package com.machineinventory.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "machines", uniqueConstraints = @UniqueConstraint(columnNames = "hostname"))
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String hostname;

    private String username;
    private String installedOS;
    private String cpuDetails;
    private String ramDetails;
    private String privateIpAddress;
    private String publicIpAddress;
    private String cloudProviderUrl;

    private Integer vncPort;

    @Enumerated(EnumType.STRING)
    private AccessibilityStatus accessibilityStatus;

    private String remarks;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
        lastModifiedDate = creationDate;
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }

    public enum AccessibilityStatus {
        ACCESSIBLE, RESTRICTED, INACCESSIBLE, DECOMMISSIONED
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInstalledOS() {
		return installedOS;
	}

	public void setInstalledOS(String installedOS) {
		this.installedOS = installedOS;
	}

	public String getCpuDetails() {
		return cpuDetails;
	}

	public void setCpuDetails(String cpuDetails) {
		this.cpuDetails = cpuDetails;
	}

	public String getRamDetails() {
		return ramDetails;
	}

	public void setRamDetails(String ramDetails) {
		this.ramDetails = ramDetails;
	}

	public String getPrivateIpAddress() {
		return privateIpAddress;
	}

	public void setPrivateIpAddress(String privateIpAddress) {
		this.privateIpAddress = privateIpAddress;
	}

	public String getPublicIpAddress() {
		return publicIpAddress;
	}

	public void setPublicIpAddress(String publicIpAddress) {
		this.publicIpAddress = publicIpAddress;
	}

	public String getCloudProviderUrl() {
		return cloudProviderUrl;
	}

	public void setCloudProviderUrl(String cloudProviderUrl) {
		this.cloudProviderUrl = cloudProviderUrl;
	}

	public Integer getVncPort() {
		return vncPort;
	}

	public void setVncPort(Integer vncPort) {
		this.vncPort = vncPort;
	}

	public AccessibilityStatus getAccessibilityStatus() {
		return accessibilityStatus;
	}

	public void setAccessibilityStatus(AccessibilityStatus accessibilityStatus) {
		this.accessibilityStatus = accessibilityStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

    
    
}
