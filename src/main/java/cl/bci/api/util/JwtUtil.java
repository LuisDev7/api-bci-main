package cl.bci.api.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class JwtUtil {
    public JwtUtil() {
    }

    public String getJWTToken(String username) {
        String secretKey = "mySKeyREeMV-gklHgk";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder().setId("nisumJWT").setSubject(username).claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())).setIssuedAt(new Date(System.currentTimeMillis())).signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return token;
    }
}
