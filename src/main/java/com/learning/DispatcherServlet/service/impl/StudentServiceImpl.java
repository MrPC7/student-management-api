package com.learning.DispatcherServlet.service.impl;

import com.learning.DispatcherServlet.Student;
import com.learning.DispatcherServlet.dto.AddStudentRequestDto;
import com.learning.DispatcherServlet.dto.StudentDto;
import com.learning.DispatcherServlet.repository.StudentRepository;
import com.learning.DispatcherServlet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();
//        List<StudentDto> studentDtoList = students
                return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                )).toList();

//        return List.of();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with ID "+id));
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student=studentRepository.save(newStudent);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not exist by id:"+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto){
        Student student= studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found with ID "+id));
        modelMapper.map(addStudentRequestDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student= studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found with ID "+id));
        updates.forEach((field, value)->{
            switch (field){
                case "name": student.setName((String) value);
                break;
                case "email": student.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

}
