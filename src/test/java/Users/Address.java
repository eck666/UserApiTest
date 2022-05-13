package Users;

import lombok.Data;

@Data
public class Address{
	private String zipcode;
	private Geo geo;
	private String city;
	private String street;
}