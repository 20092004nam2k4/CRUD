package com.example.demo.repository;

import com.example.demo.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepository extends CrudRepository<Staff, Long> {
}
