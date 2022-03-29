package peaksoft.jwt.services;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import peaksoft.jwt.dto.AuthRequest;
import peaksoft.jwt.dto.AuthResponse;
import peaksoft.jwt.jwt.JwtUtils;
import peaksoft.jwt.models.Student;

/**
 * @author Beksultan
 */
@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException badCredentialsException) {
            throw new BadCredentialsException("invalid email or password");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());

        String token = jwtUtils.generateJWTToken(authentication);

        return AuthResponse.builder()
                .email(userDetails.getUsername())
                .token(token)
                .build();
    }
}
