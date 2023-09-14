package org.example.user.Utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.springcloud.common.Exception.BusinessException;
import com.springcloud.common.Exception.ErrorCodeimpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.user.Entity.User;
import org.example.user.Vo.TokenVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {

	private static final long EXPIRE = 1000 * 60 * 60 * 24;

	private static final String APP_SECERT = "saseessrtkookppijhfewewsadhuutresxvhjkk";

	//生成token字符串
	public static String createtoken(User user) {
		return Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setHeaderParam("arg", "HS256")
				.setSubject("police-user")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
				.claim("roleId", user.getRoleid())
				.claim("username", user.getUsername())
				.claim("password", user.getPassword())
				.signWith(SignatureAlgorithm.HS256, APP_SECERT)
				.compact();
	}

	/**
	 * 获取请求头得token，并返回用户数据
	 * @param request
	 * @return
	 */
	public static TokenVo getuserInfoBytoken(HttpServletRequest request) {
		String token = request.getHeader("authorization");
		if (StringUtils.isEmpty(token)) {
			throw new BusinessException(ErrorCodeimpl.UNAUTHORIZED);
		}
		Jws<Claims> claimsJws;
try {
	claimsJws = Jwts.parser().setSigningKey(APP_SECERT ).parseClaimsJws(token);
}catch (Exception e) {
	throw new BusinessException(ErrorCodeimpl.E_200001);
}
		Claims claims = claimsJws.getBody();
		return TokenVo.builder()
				.roleId(claims.get("roleId", Integer.class))
				.username(claims.get("username", String.class))
				.password(claims.get("password", String.class))
				.build();
	}

}
