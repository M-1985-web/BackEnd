package com.apportfolio.mmm.Security.Jwt;


import com.apportfolio.mmm.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//esta clase genera el token y tiene metodos de validacion
public class JwtProvider {
  private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

  @Value("${jwt.secret}")
  private String secret;
  @Value("${jwt.expiration}")
  private int expiration;

  //aca generamos el token
  public String generateToken(Authentication authentication) {
    UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
    return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(new Date().getTime()+expiration*1000))
      .signWith(SignatureAlgorithm.HS512, secret)
      .compact();

  }

  public String getNombreUsuarioFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }


  public boolean validatetoken(String token) {
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      return true;
    } catch (MalformedJwtException e){
      logger.error("Se formo mal el Token");
    } catch (UnsupportedJwtException e){
      logger.error("Token no soportado");
    } catch (ExpiredJwtException e){
      logger.error("Expiro su Token");
    } catch (IllegalArgumentException e){
      logger.error("token Vacio");
    } catch (SignatureException e){
      logger.error("Firma no valida");
    }
    return false;


  }




}
