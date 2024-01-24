package com.achyuth.dockerdemo.dao;

import com.achyuth.dockerdemo.model.TestClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<TestClass, Integer> {
}
