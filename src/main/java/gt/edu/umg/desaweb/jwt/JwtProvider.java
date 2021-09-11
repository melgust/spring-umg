package gt.edu.umg.desaweb.jwt;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import gt.edu.umg.desaweb.service.EncryptService;
import gt.edu.umg.desaweb.utils.ConfigProperty;
import gt.edu.umg.desaweb.utils.UserPrinciple;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
	
	private String jwtPassword;
	private int jwtExpiration;
	private String seed;
	
	@Autowired
	EncryptService encryptService;
	
	@Autowired
	public JwtProvider(ConfigProperty p) {
		this.jwtPassword = p.getJwtSecret();
		this.jwtExpiration = p.getJwtExpiration();
		this.seed = p.getSeed();
	}
	
	public String generateJwtToken(Authentication authentication, String key) {
		UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
		Date expiration = getDateExpiration(this.jwtExpiration);
		return Jwts.builder().setSubject((userPrinciple.getUsername())).setIssuedAt(new Date())
				.setExpiration(expiration)
				.claim("scopes", userPrinciple.getAuthorities())
				.claim("loginKey", encryptService.encrypt(key, this.seed))
				.signWith(SignatureAlgorithm.HS512, this.jwtPassword).compact();
	}
	
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(this.jwtPassword).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getUsernameFromJWtToken(String token) {
		return Jwts.parser().setSigningKey(jwtPassword).parseClaimsJws(token).getBody().getSubject();
	}
	
	public long getUserIdFromJwt(Authentication authentication, HttpServletRequest request) {
		long personaId;
		String token = request.getHeader("Authorization");
        token = token.replace("Bearer ", "");
        Claims claims = Jwts.parser().setSigningKey(jwtPassword).parseClaimsJws(token).getBody();
		String key = (String) claims.get("loginKey");
		key = encryptService.decrypt(key, seed);
		personaId = Long.parseLong(key);
		return personaId;
	}
	
	private static Date getDateExpiration(int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}

	private static Date getDateExpirationGuest() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 30);
		return calendar.getTime();
	}

}
