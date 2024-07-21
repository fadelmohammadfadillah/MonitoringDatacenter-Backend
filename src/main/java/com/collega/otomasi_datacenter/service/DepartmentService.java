package com.collega.otomasi_datacenter.service;

import java.util.Arrays;
import java.util.List;
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
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Data divisi tidak ditemukan!"));
            var department = Department.builder()
                                .departmentName(request.getDepartmentName().toUpperCase())
                                .idDivisi(divisi)
                                .build();
            departmentRepository.save(department);
            return "Department baru berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Department baru gagal ditambahkan!" + e.getMessage());
        }
    }

    public String updateDepartment(Integer id, DepartmentRequest request){
        try {
            Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department tidak ditemukan!"));
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Divisi tidak ditemukan!")); 
            department.setDepartmentName(request.getDepartmentName().toUpperCase());
            department.setIdDivisi(divisi);
            departmentRepository.save(department);
            return "Data perubahan department berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data department tidak berhasil!" + e.getMessage());
        }
    }

    public String deleteDepartment(Integer id){
        try {
            Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department tidak ditemukan!"));
            departmentRepository.delete(department);
            return "Data department berhasil di hapus!";
        } catch (DataIntegrityViolationException e) {
            String userDept = getUserDeptByIdDept(id);
            throw new DataIntegrityViolationException("Constraint foreign key, List Department: " + userDept);
        }catch (RuntimeException e) {
            throw new RuntimeException("Data department tidak ditemukan" + e.getMessage());
        }
    }

    public String getUserDeptByIdDept(Integer idDepartment){
        try {
            Department department = departmentRepository.findById(idDepartment)
                .orElseThrow(() -> new RuntimeException("Department tidak ditemukan!"));
            String[] departments = userDeptRepository.findByIdDepartment(department)
                                    .stream().map(UserDepartment::getUsername)
                                    .toArray(String[]::new);
            return Arrays.toString(departments);
        } catch (Exception e) {
            throw new RuntimeException("Nama department tidak ditemukan!");
        }
    }

    public List<DepartmentRequest> getAllDepartments(){
        List<Object[]> results = departmentRepository.findAllDepartmentNamesWithDivisiNames();
        return results.stream().map(result -> {
                    DepartmentRequest deptReq = DepartmentRequest.builder()
                                            .idDepartment((Integer) result[0])
                                            .idDivisi((Integer) result[1])
                                            .departmentName((String) result[2])
                                            .divisiName((String) result[3])
                                            .build();
                    return deptReq;
                })
                .collect(Collectors.toList());
    }

}
