package peaksoft.jwt.dto.student;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Beksultan
 */
@Getter @Setter
public class StudentRequestDto {

    private String email;
    private String password;
}
