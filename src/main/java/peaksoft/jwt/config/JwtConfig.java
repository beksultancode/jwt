package peaksoft.jwt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

/**
 * @author Beksultan
 */
@Configuration
@ConfigurationProperties(prefix = "application.jwt")
@Getter @Setter
public class JwtConfig {

    private String tokenPrefix;
    private String secretKey;
    private long tokenExpirationAfterDays;

    public void setTokenExpirationAfterDays(int tokenExpirationAfterDays) {
        this.tokenExpirationAfterDays = tokenExpirationAfterDays * 8600000;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
