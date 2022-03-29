package peaksoft.jwt.apis;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import peaksoft.jwt.dto.AuthRequest;
import peaksoft.jwt.dto.AuthResponse;
import peaksoft.jwt.models.Student;
import peaksoft.jwt.services.AuthService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author Beksultan
 */
@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping
    @PermitAll
    public AuthResponse authentication(@RequestBody @Valid AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

    @GetMapping("/test")
    public Map<String, String> testJWT(Authentication authentication) {
        return Map.of(
                "who", authentication.getName(),
                "status", Status.SUCCESS.name()
        );
    }
}

enum Status {
    SUCCESS
}
