package com.student.service.impl;

import com.student.models.Student;
import com.student.repositories.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }
}
