package tn.cni.injez.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TypeLotAppelOffre {
	@JsonProperty("تمويل مشروع")
	تمويل_مشروع ,
	@JsonProperty("تنفيذ مشروع")
	تنفيذ_مشروع,
	@JsonProperty("دراسة مشروع")
	دراسة_مشروع;
	 
	   
	    
	    
}
