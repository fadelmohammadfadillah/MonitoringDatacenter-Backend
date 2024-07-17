package com.collega.otomasi_datacenter.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
            Optional<Divisi> optDivisi = divisiRepository.findById(id);
            Divisi divisi = optDivisi.get();
            divisi.setDivisiName(request.getDivisiName());
            divisiRepository.save(divisi);
            return "Data divisi berhasil di update!";
        } catch (RuntimeException e) {
            // TODO: handle exception
            throw new RuntimeException("Data divisi tidak ditemukan!");
        }
    }

    public String deleteDivisi(Integer id){
        try {
            Optional<Divisi> optDivisi = divisiRepository.findById(id);
            Divisi divisi = optDivisi.get();
            divisiRepository.delete(divisi);
            return "Data divisi berhasil di hapus!";
        } catch (DataIntegrityViolationException e){
            String department = getDepartmentByIdDivisi(id);
            throw new DataIntegrityViolationException("Constraint foreign key, List Department: " + department);
        } 
        catch (RuntimeException e) {
            throw new RuntimeException("Data divisi tidak ditemukan");
        }
    }

    public String getDepartmentByIdDivisi(Integer id){
        Optional<Divisi> divisi = divisiRepository.findById(id);
        if(divisi.isPresent()){
            String[] departments = departmentRepository.findByIdDivisi(divisi.get())
                                    .stream().map(Department::getDepartmentName)
                                    .toArray(String[]::new);
            return Arrays.toString(departments);
        }else{
            throw new RuntimeException("Nama divisi tidak ditemukan!");
        }
    }

    public List<Divisi> getAllDivisi(){
        return divisiRepository.findAll();
    }

    public List<UserDivisi> findByDivisiName(String divisiName){
        // format divisi menjadi uppercase agar menghindari error
        divisiName = divisiName.toUpperCase();
        Optional<Divisi> divisi = divisiRepository.findByDivisiName(divisiName);
        if(divisi.isPresent()){
            return userDivRepository.findByIdDivisi(divisi.get());
        }else{
            throw new RuntimeException("Nama divisi tidak ditemukan!");
        }
    }

    public List<UserDivisi> getAllUserDivisi(){
        return userDivRepository.findAll();
    }
}


