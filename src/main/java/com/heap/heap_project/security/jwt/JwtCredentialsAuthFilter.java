package com.heap.heap_project.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heap.heap_project.security.auth.AuthenticationRequestTemplate;
import com.heap.heap_project.security.auth.subscription.SubscriptionRequestTemplate;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
public class JwtCredentialsAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;


    // Récupération des données client et tentative d'authentification
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try{
            // Réception de la request de type HttpServlet puis conversion grâce au ObjectMapper en SubscriptionRequestTemplate
            // Type SubsReqTemplate qui permet d'avoir accès au password/username. Stock le tout dans un OM qui prend en param 1 les entrées clavier et en param 2indique le format dans notre class SubsReqTemplate
            AuthenticationRequestTemplate authenticationRequest = new ObjectMapper().readValue(request.getInputStream(), AuthenticationRequestTemplate.class);

            // Passer les données dans un "moule" destiné à l'authentication (sorte de pont/conteneur)
            // Conversion en type Authentication qu'attent la fonction authenticate() en dessous
            // On utilise authenticationRequest qui vient d'être rempli des données clients au dessus et avoir accès au getter/setter de la class
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );

            // Tentative d'authentification
            // On utilise l'instance authenticationManager qui dispose d'une méthode authenticate() pour authentifier/non nos données clients dans le moule authentication
            Authentication tryAuthentication = authenticationManager.authenticate(authentication);

            // On return l'authentication finale
            return tryAuthentication;

        } catch(IOException exception){
            throw new RuntimeException(exception);
            }

    }
    // Création et renvoi du Token au client si authentifié
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication tryAuthenticationSucces) throws IOException, ServletException {

        // Création token
        String token = Jwts.builder()
                .setSubject(tryAuthenticationSucces.getName()) // On définie le "sujet" de notre token autrement dit à qui est envoyé/appartient ce token. getName() fait souvent reférence au username/email
                .claim("authorities", tryAuthenticationSucces.getAuthorities()) // On définie les authorities propre à l'user dans le body/claim du token
                .setIssuedAt(new Date()) // Set la date de création du token
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenDateExpirationDays()))) // Quand le token va expirer
                .signWith(jwtConfig.getSecretKey())
                .compact();

        // Renvoie du token dans le header de la response envoyée au client de la part du sever
        response.addHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + token);
    }
}

