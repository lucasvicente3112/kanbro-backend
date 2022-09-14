package tcc.kanbro.security;

import io.jsonwebtoken.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tcc.kanbro.model.Usuario;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

    @Value("${kanbro.secret}")
    private String SECRET_KEY;

    public String generateAccessToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", usuario.getIdUsuario(), usuario.getEmail()))
                .setIssuer("Kanbro")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

    }
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT Expirou", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token esta nulo, vazio ou contém apenas um espaço em branco", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT é inválido", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT não é suportado", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Falha na validação da assinatura");
        }

        return false;
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}