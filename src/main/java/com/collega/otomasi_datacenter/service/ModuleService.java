package com.collega.otomasi_datacenter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Module;
import com.collega.otomasi_datacenter.model.Subproduct;
import com.collega.otomasi_datacenter.repository.ModuleRepository;
import com.collega.otomasi_datacenter.repository.SubproductRepository;
import com.collega.otomasi_datacenter.vo.ModuleRequest;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private SubproductRepository subproductRepository;

    public String createModule(ModuleRequest request){
        try {
            Subproduct subproduct = subproductRepository.findById(request.getIdSubproduct())
                .orElseThrow(() -> new RuntimeException("Data subproduct tidak ditemukan!")); 
            var module = Module.builder()
                            .moduleName(request.getModuleName().toUpperCase())
                            .profile(request.getProfile().toUpperCase())
                            .idSubproduct(subproduct)
                            .build();
            moduleRepository.save(module);
            return "Module berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Module baru gagal ditambahkan!" + e.getMessage());
        }
    }

    public String updateModule(Integer id, ModuleRequest request){
        try {
            Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data module tidak ditemukan!"));
            Subproduct subproduct = subproductRepository.findById(request.getIdSubproduct())
                .orElseThrow(() -> new RuntimeException("Data subproduct tidak ditemukan!"));
            module.setModuleName(request.getModuleName().toUpperCase());
            module.setProfile(request.getProfile().toUpperCase());
            module.setIdSubproduct(subproduct);
            moduleRepository.save(module);
            return "Data perubahan module berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data module gagal disimpan! " + e.getMessage());
        }
    }

    public String deleteModule(Integer id){
        try {
            Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data module tidak ditemukan!"));
            moduleRepository.delete(module);
            return "Data module berhasil di hapus!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Data module gagal dihapus!"  + e.getMessage());
        }
    }

    public List<ModuleRequest> getAllModule(){
        List<Object[]> results = moduleRepository.findAllModuleWithSubproduct();
        return results.stream().map(result -> {
            ModuleRequest moduleReq = ModuleRequest.builder()
                                        .idModule((Integer) result[0])
                                        .idSubproduct((Integer) result[1])
                                        .moduleName((String) result[2])
                                        .profile((String) result[3])
                                        .subproductName((String) result[4])
                                        .build();
            return moduleReq;
        })
        .collect(Collectors.toList());
    }
}
