package com.inventorymgmt.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
@ConfigurationProperties(prefix="network")
public class NetworkSetting {
	String businessType;
	String location;

}
