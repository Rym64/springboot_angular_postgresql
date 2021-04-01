package tn.cni.injez.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum  Role {
	@JsonProperty("مستخدم")
	مستخدم,
	@JsonProperty("مُشْرِف")
	مُشْرِف,
	@JsonProperty("مُشْرِف بالمركز الوطني للإعلامية")
	مُشْرِف_بالمركز_الوطني_للإعلامية;
	
}