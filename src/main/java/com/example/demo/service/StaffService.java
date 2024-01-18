package com.example.demo.service;

import com.example.demo.model.Staff;
import com.example.demo.repository.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService implements IStaffService {
@Autowired
private IStaffRepository iStaffRepository;
    @Override
    public Iterable<Staff> findAll() {
        return  iStaffRepository.findAll();
    }

    @Override
    public Optional<Staff> findByID(Long id) {
         return iStaffRepository.findById(id);
    }

    @Override
    public void save(Staff staff) {
iStaffRepository.save(staff);
    }

    @Override
    public void remote(Long id) {
        iStaffRepository.deleteById(id);
    }

    @Override
    public Staff getCustomerById(Long id) {
        return null;
    }
}
