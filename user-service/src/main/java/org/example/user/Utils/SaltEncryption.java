package org.example.user.Utils;

import org.springframework.util.DigestUtils;

public class SaltEncryption {

	public static String saltEncryption(String password, String salt) {
     String result=password+salt;
	 return DigestUtils.md5DigestAsHex(result.getBytes());
	}

}
