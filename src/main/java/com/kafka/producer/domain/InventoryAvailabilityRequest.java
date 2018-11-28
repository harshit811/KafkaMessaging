package com.kafka.producer.domain;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryAvailabilityRequest  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "IA1001")
	@JsonProperty("locations")
	private List<String> storeIdList;

	@NotEmpty(message = "IA1002")
	@JsonProperty("products")
	private List<String> skuIdList;

}
