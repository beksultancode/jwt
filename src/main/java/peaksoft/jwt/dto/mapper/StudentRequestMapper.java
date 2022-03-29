package peaksoft.jwt.dto.mapper;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import peaksoft.jwt.dto.student.StudentRequestDto;
import peaksoft.jwt.models.Authority;
import peaksoft.jwt.models.Student;

/**
 * @author Beksultan
 */
@Component
@AllArgsConstructor
public class StudentRequestMapper implements Converter<StudentRequestDto, Student> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Student convert(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setEmail(studentRequestDto.getEmail());
        student.setPassword(passwordEncoder.encode(studentRequestDto.getPassword()));
        student.setAuthority(Authority.STUDENT);
        return student;
    }
}
