package com.example.student_management_backend.service;

import com.example.student_management_backend.dto.StudentRequest;
import com.example.student_management_backend.dto.StudentResponse;
import com.example.student_management_backend.entity.Student;
import com.example.student_management_backend.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.example.student_management_backend.exception.StudentNotFoundException;
import com.example.student_management_backend.exception.DuplicateEmailException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        return convertToResponse(student);
    }

    public StudentResponse createStudent(StudentRequest request) {

        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException(request.getEmail());
        }

        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());
        student.setPhone(request.getPhone());

        Student savedStudent = studentRepository.save(student);

        return convertToResponse(savedStudent);
    }

    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }

        studentRepository.deleteById(id);
    }

    private StudentResponse convertToResponse(Student student) {

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getCourse(),
                student.getPhone()
        );
    }

    public StudentResponse updateStudent(
            Long id,
            StudentRequest request) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        existingStudent.setName(request.getName());
        existingStudent.setEmail(request.getEmail());
        existingStudent.setAge(request.getAge());
        existingStudent.setCourse(request.getCourse());
        existingStudent.setPhone(request.getPhone());

        Student updatedStudent =
                studentRepository.save(existingStudent);

        return convertToResponse(updatedStudent);

    }
}