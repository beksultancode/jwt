package peaksoft.jwt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Beksultan
 */
@Builder
@Getter @Setter
public class AuthResponse {
    private String email;
    private String token;
}
