package com.collega.otomasi_datacenter.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.UserDepartment;
import com.collega.otomasi_datacenter.repository.DepartmentRepository;
import com.collega.otomasi_datacenter.repository.DivisiRepository;
import com.collega.otomasi_datacenter.repository.UserDeptRepository;
import com.collega.otomasi_datacenter.vo.DepartmentRequest;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserDeptRepository userDeptRepository;

    @Autowired
    private DivisiRepository divisiRepository;

    public String createDepartment(DepartmentRequest request){
        try {
            Optional<Divisi> divisi = divisiRepository.findById(request.getIdDivisi());
            var department = Department.builder()
                                .departmentName(request.getDepartmentName().toUpperCase())
                                .idDivisi(divisi.get())
                                .build();
            departmentRepository.save(department);
            return "Department baru berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Department baru gagal ditambahkan!");
        }
    }

    public String updateDepartment(Integer id, DepartmentRequest request){
        try {
            Optional<Department> optDept = departmentRepository.findById(id);
            Department department = optDept.get();
            department.setDepartmentName(request.getDepartmentName());
            Optional<Divisi> optDiv = divisiRepository.findById(request.getIdDivisi()); 
            department.setIdDivisi(optDiv.get());
            departmentRepository.save(department);
            return "Data perubahan department berhasil disimpan!";
        } catch (Exception e) {
            throw new RuntimeException("Data department tidak ditemukan!");
        }
    }

    public String deleteDepartment(Integer id){
        try {
            Optional<Department> optDept = departmentRepository.findById(id);
            Department department =  optDept.get();
            departmentRepository.delete(department);
            return "Data department berhasil di hapus!";
        } catch (DataIntegrityViolationException e) {
            String userDept = getUserDeptByIdDept(id);
            throw new DataIntegrityViolationException("Constraint foreign key, List Department: " + userDept);
        }
    }

    public String getUserDeptByIdDept(Integer idDepartment){
        Optional<Department> department = departmentRepository.findById(idDepartment);
        if(department.isPresent()){
            String[] departments = userDeptRepository.findByIdDepartment(department.get())
                                    .stream().map(UserDepartment::getUsername)
                                    .toArray(String[]::new);
            return Arrays.toString(departments);
        }else{
            throw new RuntimeException("Nama department tidak ditemukan!");
        }
    }

    public List<Map<String, Object>> getAllDepartments(){
        List<Object[]> results = departmentRepository.findAllDepartmentNamesWithDivisiNames();
        return results.stream().map(result -> {
                Map<String, Object> map = new HashMap<>();
                map.put("idDepartment", result[0]);
                map.put("idDivisi", result[1]);
                map.put("departmentName", result[2]);
                map.put("divisiName", result[3]);
                return map;
            })
            .collect(Collectors.toList());
    }

}
