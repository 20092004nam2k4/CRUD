package com.example.demo.service;

import com.example.demo.model.Staff;
import com.example.demo.repository.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService implements IStaffService {
@Autowired
private IStaffRepository iStaffRepository;
    @Override
    public Iterable<Staff> findAll() {

        return  iStaffRepository.findAll();
    }

    @Override
    public Staff findByID(Long id) {
        return null;
    }

    @Override
    public void save(Staff staff) {

    }

    @Override
    public void delete(Long id) {

    }
}
