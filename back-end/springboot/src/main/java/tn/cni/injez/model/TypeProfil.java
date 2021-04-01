package tn.cni.injez.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TypeProfil {
	@JsonProperty("جميع الصلاحيات")
	جميع_الصلاحيات,
	@JsonProperty("تمويل")
	تمويل,
	@JsonProperty("تقسيم")
	تقسيم,
	@JsonProperty("طلبات العروض و صفقات و فواتير")
	طلبات_العروض_و_صفقات_و_فواتير,
	@JsonProperty("أهداف ومؤشرات")
	أهداف_و_مؤشرات,
	@JsonProperty("إحصائيات")
	إحصائيات; 
}
