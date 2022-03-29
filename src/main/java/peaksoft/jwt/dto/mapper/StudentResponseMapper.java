package peaksoft.jwt.dto.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import peaksoft.jwt.dto.student.StudentRequestDto;
import peaksoft.jwt.dto.student.StudentResponseDto;
import peaksoft.jwt.models.Student;

/**
 * @author Beksultan
 */
@Component
public class StudentResponseMapper implements Converter<Student, StudentResponseDto> {
    @Override
    public StudentResponseDto convert(Student student) {
        StudentResponseDto studentRequestDto = new StudentResponseDto();
        studentRequestDto.setEmail(student.getEmail());
        return studentRequestDto;
    }
}
