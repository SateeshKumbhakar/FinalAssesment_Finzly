
package com.bbc.ops.BBCOps.security;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.bbc.ops.BBCOps.model.Employee;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class MySecurity {
	
	private static final int EXPIRATION_TIME = 360000;
	SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	

	public  String generateToken(Employee employee) {
	    // Set the JWT Claims
	    return Jwts.builder()
	    		.setSubject("user123")
	    	    .signWith(key)
	    	    .compact();
	}
}
