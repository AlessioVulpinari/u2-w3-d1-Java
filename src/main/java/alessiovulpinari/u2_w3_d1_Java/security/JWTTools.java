package alessiovulpinari.u2_w3_d1_Java.security;

import alessiovulpinari.u2_w3_d1_Java.entities.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {

    @Value("${jwt.secret}")
    private String secret;

    public String createToken(Employee employee) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis())) // Data di creazione token in millisecondi
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 10)) // Data di scadenza token in millisecondi
                .subject(String.valueOf(employee.getEmployeeId())) // Il soggetto (meglio passare l'id e non altri dati)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())) // Creazione della Signature grazie al body e al segreto
                .compact();
    }
}
