package peaksoft.jwt.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Beksultan
 */
public enum Authority implements GrantedAuthority {
    STUDENT,
    TEACHER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
