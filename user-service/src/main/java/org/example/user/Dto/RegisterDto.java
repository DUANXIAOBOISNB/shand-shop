package org.example.user.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

	/**
	 *
	 */
	private String username;

	/**
	 *
	 */
	private String email;

	/**
	 *
	 */
	private String password;

	/**
	 *
	 */
	private String fullname;

	/**
	 *
	 */
	private String address;

	/**
	 *
	 */
	private String phonenumber;
	private  String profile;
}
