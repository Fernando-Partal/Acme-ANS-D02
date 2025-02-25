
package acme.entities.airports;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airport extends AbstractEntity {

	@Mandatory
	@ValidString(min = 1, max = 50)
	private String	name;

	@Mandatory
	@ValidString(min = 1, max = 50, pattern = "^[A-Z]{3}X$")
	@Column(unique = true)
	private String	iataCode;

	@Mandatory
	@NotBlank
	@Pattern(regexp = "INTERNATIONAL|DOMESTIC|REGIONAL")
	private String	scope;

	@Mandatory
	@ValidString(min = 1, max = 50)
	private String	city;

	@Mandatory
	@ValidString(min = 1, max = 50)
	private String	country;

	@ValidUrl
	private String	web;

	@Email
	@ValidEmail
	private String	email;

	@ValidNumber
	@Pattern(regexp = "^\\+?\\d{6,15}$")
	private String	phoneNumber;

	private String	landingRunway;

	private String	takeOffRunway;

}
