package peaksoft.jwt.apis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.jwt.dto.student.StudentRequestDto;
import peaksoft.jwt.dto.student.StudentResponseDto;
import peaksoft.jwt.services.StudentService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

/**
 * @author Beksultan
 */
@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @PostMapping("/save")
    @PermitAll
    public StudentResponseDto save(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.save(studentRequestDto);
    }

}
