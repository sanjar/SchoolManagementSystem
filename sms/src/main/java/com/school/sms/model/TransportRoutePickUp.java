package com.school.sms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "sms_transport_pick_up_master")
public class TransportRoutePickUp  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="pick_up_master_id")
	private Integer pickUpMasterId;
	
	@Column(name="route_code")
	private Integer routeCode;
	
	@Column(name="pick_up_id")
	private String pickUpId;
	
	@Column(name="pick_up_name")
	private String pickUpName;
	
	@Column(name="vehicle_id")
	private Integer vehicleId;
	
	@Column(name="pick_up_time")
	private String pickUpTime;
	
	@Column(name="transport_cost_jan")
	private String transportCostJan;
	
	@Column(name="transport_cost_feb")
	private String transportCostFeb;
	
	@Column(name="transport_cost_mar")
	private String transportCostMar;
	
	@Column(name="transport_cost_apr")
	private String transportCostApr;
	
	@Column(name="transport_cost_may")
	private String transportCostMay;
	
	@Column(name="transport_cost_jun")
	private String transportCostJun;
	
	@Column(name="transport_cost_jul")
	private String transportCostJul;
	
	@Column(name="transport_cost_aug")
	private String transportCostAug;
	
	@Column(name="transport_cost_sep")
	private String transportCostSep;
	
	@Column(name="transport_cost_oct")
	private String transportCostOct;
	
	@Column(name="transport_cost_nov")
	private String transportCostNov;
	
	@Column(name="transport_cost_dec")
	private String transportCostDec;

	public Integer getPickUpMasterId() {
		return pickUpMasterId;
	}

	public Integer getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(Integer routeCode) {
		this.routeCode = routeCode;
	}

	public String getPickUpId() {
		return pickUpId;
	}

	public void setPickUpId(String pickUpId) {
		this.pickUpId = pickUpId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getTransportCostJan() {
		return transportCostJan;
	}

	public void setTransportCostJan(String transportCostJan) {
		this.transportCostJan = transportCostJan;
	}

	public String getTransportCostFeb() {
		return transportCostFeb;
	}

	public void setTransportCostFeb(String transportCostFeb) {
		this.transportCostFeb = transportCostFeb;
	}

	public String getTransportCostMar() {
		return transportCostMar;
	}

	public void setTransportCostMar(String transportCostMar) {
		this.transportCostMar = transportCostMar;
	}

	public String getTransportCostApr() {
		return transportCostApr;
	}

	public void setTransportCostApr(String transportCostApr) {
		this.transportCostApr = transportCostApr;
	}

	public String getTransportCostMay() {
		return transportCostMay;
	}

	public void setTransportCostMay(String transportCostMay) {
		this.transportCostMay = transportCostMay;
	}

	public String getTransportCostJun() {
		return transportCostJun;
	}

	public void setTransportCostJun(String transportCostJun) {
		this.transportCostJun = transportCostJun;
	}

	public String getTransportCostJul() {
		return transportCostJul;
	}

	public void setTransportCostJul(String transportCostJul) {
		this.transportCostJul = transportCostJul;
	}

	public String getTransportCostAug() {
		return transportCostAug;
	}

	public void setTransportCostAug(String transportCostAug) {
		this.transportCostAug = transportCostAug;
	}

	public String getTransportCostSep() {
		return transportCostSep;
	}

	public void setTransportCostSep(String transportCostSep) {
		this.transportCostSep = transportCostSep;
	}

	public String getTransportCostOct() {
		return transportCostOct;
	}

	public void setTransportCostOct(String transportCostOct) {
		this.transportCostOct = transportCostOct;
	}

	public String getTransportCostNov() {
		return transportCostNov;
	}

	public void setTransportCostNov(String transportCostNov) {
		this.transportCostNov = transportCostNov;
	}

	public String getTransportCostDec() {
		return transportCostDec;
	}

	public void setTransportCostDec(String transportCostDec) {
		this.transportCostDec = transportCostDec;
	}

	public void setPickUpMasterId(Integer pickUpMasterId) {
		this.pickUpMasterId = pickUpMasterId;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TransportRoutePickUp) {
			if (((TransportRoutePickUp) obj).getPickUpMasterId().equals(
					this.pickUpMasterId)) {
				return true;
			}
		}
		return super.equals(obj);
	}

	public String getPickUpName() {
		return pickUpName;
	}

	public void setPickUpName(String pickUpName) {
		this.pickUpName = pickUpName;
	}

	
	
}
