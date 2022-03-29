package peaksoft.jwt.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.jwt.annonation.password.ValidPassword;

import javax.validation.constraints.Email;

/**
 * @author Beksultan
 */
@Getter @Setter
public class AuthRequest {
    @Email
    private String email;
    @ValidPassword
    private String password;
}
