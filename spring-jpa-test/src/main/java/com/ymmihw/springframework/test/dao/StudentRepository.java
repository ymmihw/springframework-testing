package com.ymmihw.springframework.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ymmihw.springframework.test.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
