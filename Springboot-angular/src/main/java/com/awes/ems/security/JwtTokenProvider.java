package com.awes.ems.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.awes.ems.utility.DateUtility;
@Component
public class JwtTokenProvider {
	private static final String CLAIM_SUB="sub";
    private static final String CLAIM_IAT="iat";
    private static final String EXPIRATION_TIME="18000";
    private static final String SECRET_KEY="ems";
    private static final String CLAIM_EXP="exp";
  
    
    private static final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
    
	
	
	public String generateToken(Authentication authentication) {

		EmployeePrincipal employeePrincipal = (EmployeePrincipal) authentication.getPrincipal();
		Date now = DateUtility.now();
        Date expiryDate = new Date(now.getTime() + Integer.parseInt(EXPIRATION_TIME));
        return JWT.create()
				.withClaim(CLAIM_SUB, Long.toString(employeePrincipal.getId()))
				.withClaim(CLAIM_IAT, now)
				.withClaim(CLAIM_EXP, expiryDate)
				.sign(Algorithm.HMAC512(SECRET_KEY));     
	}

	public Claim getClaimFromJwt(String token,String claim) {
		try {
		
			JWTVerifier verifier = JWT.require(Algorithm.HMAC512(SECRET_KEY)).build();
			DecodedJWT decodedJWT = verifier.verify(token);
			return decodedJWT.getClaim(claim);
		}catch (Exception e) {
			log.error("Exception: getClaimFromJwt : {}",e.getMessage());
			return null;
		}
	}
	
	public Long getUserIdFromJWT(String token) {
		Claim claim = getClaimFromJwt(token, CLAIM_SUB); 
		return claim != null ? Long.parseLong(claim.asString()) : null;
	}

	public boolean validateToken(String authToken) {
		return this.getUserIdFromJWT(authToken) != null;
	}

}
