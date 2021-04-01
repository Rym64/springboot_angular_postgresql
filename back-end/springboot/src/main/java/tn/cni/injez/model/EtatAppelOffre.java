package tn.cni.injez.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EtatAppelOffre {
	@JsonProperty("موافَق عليها")
	موافَق_عليها,
	@JsonProperty("جارية")
	جارية,
	@JsonProperty("ملغاة")
	ملغاة
	
	

}
