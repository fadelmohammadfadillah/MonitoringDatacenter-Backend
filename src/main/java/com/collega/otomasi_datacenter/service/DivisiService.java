package com.collega.otomasi_datacenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.UserDivisi;
import com.collega.otomasi_datacenter.repository.DepartmentRepository;
import com.collega.otomasi_datacenter.repository.DivisiRepository;
import com.collega.otomasi_datacenter.repository.UserDivRepository;
import com.collega.otomasi_datacenter.vo.DivisiRequest;

@Service
public class DivisiService {

    @Autowired
    private DivisiRepository divisiRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserDivRepository userDivRepository;

    public String createDivisi(DivisiRequest request){
        try {
            var divisi = Divisi.builder()
                .divisiName(request.getDivisiName())
                .build();
            divisiRepository.save(divisi);
            return "Divisi baru berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Divisi baru gagal ditambahkan");
        }
    }

    public List<Department> getDepartmentByDivisiName(String divisiName){
        // format divisi menjadi uppercase agar menghindari error
        divisiName = divisiName.toUpperCase();
        Optional<Divisi> divisi = divisiRepository.findByDivisiName(divisiName);
        if(divisi.isPresent()){
            return departmentRepository.findByIdDivisi(divisi.get());
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


