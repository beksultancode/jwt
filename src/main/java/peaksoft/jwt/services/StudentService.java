package peaksoft.jwt.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.jwt.dto.mapper.StudentRequestMapper;
import peaksoft.jwt.dto.mapper.StudentResponseMapper;
import peaksoft.jwt.dto.student.StudentRequestDto;
import peaksoft.jwt.dto.student.StudentResponseDto;
import peaksoft.jwt.exceptions.BadRequestException;
import peaksoft.jwt.models.Student;
import peaksoft.jwt.repositories.StudentRepository;

/**
 * @author Beksultan
 */
@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentRequestMapper studentRequestMapper;
    private final StudentResponseMapper studentResponseMapper;

    public StudentResponseDto save(StudentRequestDto studentRequestDto) {
        if (studentRepository.existsByEmail(studentRequestDto.getEmail())) {
            throw new BadRequestException(
                    String.format("email = %s already in use!", studentRequestDto.getEmail())
            );
        }

        Student student = studentRequestMapper.convert(studentRequestDto);

        assert student != null;
        Student save = studentRepository.save(student);

        return studentResponseMapper.convert(save);
    }
}
