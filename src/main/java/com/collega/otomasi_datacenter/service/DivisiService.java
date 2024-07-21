package com.collega.otomasi_datacenter.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.UserDivisi;
import com.collega.otomasi_datacenter.repository.DepartmentRepository;
import com.collega.otomasi_datacenter.repository.DivisiRepository;
import com.collega.otomasi_datacenter.repository.UserDivRepository;

@Service
public class DivisiService {

    @Autowired
    private DivisiRepository divisiRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserDivRepository userDivRepository;

    public String createDivisi(Divisi request){
        try {
            var divisi = Divisi.builder()
                .divisiName(request.getDivisiName().toUpperCase())
                .build();
            divisiRepository.save(divisi);
            return "Divisi baru berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Divisi baru gagal ditambahkan");
        }
    }

    public String updateDivisi(Integer id, Divisi request){
        try {
            Divisi divisi = divisiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data divisi tidak ditemukan!"));
            divisi.setDivisiName(request.getDivisiName().toUpperCase());
            divisiRepository.save(divisi);
            return "Data perubahan divisi berhasil disimpan!";
        } catch (RuntimeException e) {
            // TODO: handle exception
            throw new RuntimeException("Data divisi tidak ditemukan!" + e.getMessage());
        }
    }

    public String deleteDivisi(Integer id){
        try {
            Divisi divisi = divisiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data divisi tidak ditemukan!"));
            divisiRepository.delete(divisi);
            return "Data divisi berhasil di hapus!";
        } catch (DataIntegrityViolationException e){
            String department = getDepartmentByIdDivisi(id);
            throw new DataIntegrityViolationException("Constraint foreign key, List Department: " + department);
            // user divisi di null id nya dulu
        } 
        catch (RuntimeException e) {
            throw new RuntimeException("Data divisi tidak ditemukan" + e.getMessage());
        }
    }

    public String getDepartmentByIdDivisi(Integer id){
        try {
            Divisi divisi = divisiRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Data divisi tidak ditemukan!"));
            String[] departments = departmentRepository.findByIdDivisi(divisi)
                                    .stream().map(Department::getDepartmentName)
                                    .toArray(String[]::new);
            return Arrays.toString(departments);
        } catch (Exception e) {
            throw new RuntimeException("Nama divisi tidak ditemukan!");
        }
    }

    public List<Divisi> getAllDivisi(){
        return divisiRepository.findAll();
    }

    public List<UserDivisi> getAllUserDivisi(){
        return userDivRepository.findAll();
    }
}


