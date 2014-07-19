package com.school.sms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_transport_route")
public class TransportRoute implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="route_code")
	private Integer routeCode;
	
	@Column(name="route_name")
	private String routeName;

	public Integer getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(Integer routeCode) {
		this.routeCode = routeCode;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
	
}
