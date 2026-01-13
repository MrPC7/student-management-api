package com.learning.DispatcherServlet.repository;

import com.learning.DispatcherServlet.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
