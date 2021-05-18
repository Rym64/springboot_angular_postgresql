package com.stagepfe.cni.payload.request;
import java.util.Set;


public class VehiculeRequest {
	private String dmc;
	private String immatD;
	private String immatG;
	 private Set<String> type;	
	 
	public String getDmc() {
		return dmc;
	}
	
	public void setDmc(String dmc) {
		this.dmc = dmc;
	}
	
	public String getImmatD() {
		return immatD;
	}
	
	public void setImmatD(String immatD) {
		this.immatD = immatD;
	}
	
	public String getImmatG() {
		return immatG;
	}

	public void setImmatG(String immatG) {
		this.immatG = immatG;
	}

	public Set<String> getType() {
		return type;
	}

	public void setType(Set<String> type) {
		this.type = type;
	}
	
}
