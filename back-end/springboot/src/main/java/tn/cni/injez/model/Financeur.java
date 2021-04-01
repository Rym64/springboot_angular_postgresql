package tn.cni.injez.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Financeur {
	@JsonProperty("رجال أعمال أجانب")
	رجال_أعمال_أجانب,
	@JsonProperty("بنوك أجنبية")
	بنوك_أجنبية,
	@JsonProperty("جمعيات أجنبية")
	جمعيات_أجنبية

}
