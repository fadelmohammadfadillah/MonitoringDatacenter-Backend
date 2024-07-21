package com.collega.otomasi_datacenter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Product;
import com.collega.otomasi_datacenter.model.Subproduct;
import com.collega.otomasi_datacenter.repository.ProductRepository;
import com.collega.otomasi_datacenter.repository.SubproductRepository;
import com.collega.otomasi_datacenter.vo.SubproductRequest;

@Service
public class SubproductService {
    @Autowired
    private SubproductRepository subproductRepository;

    @Autowired
    private ProductRepository productRepository;

    public String createSubproduct(SubproductRequest request){
        try {
            Product product = productRepository.findById(request.getIdProduct())
                .orElseThrow(() -> new RuntimeException("Data product tidak ditemukan!")); 
            var subproduct = Subproduct.builder()
                            .subproductName(request.getSubproductName().toUpperCase())
                            .idProduct(product)
                            .build();
            subproductRepository.save(subproduct);
            return "Subproduct berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Subproduct baru gagal ditambahkan!" + e.getMessage());
        }
    }

    public String updateSubproduct(Integer id, SubproductRequest request){
        try {
            Subproduct subproduct = subproductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data subproduct tidak ditemukan!"));
            Product product = productRepository.findById(request.getIdProduct())
                .orElseThrow(() -> new RuntimeException("Data product tidak ditemukan!"));
            subproduct.setSubproductName(request.getSubproductName().toUpperCase());
            subproduct.setIdProduct(product);
            subproductRepository.save(subproduct);
            return "Data perubahan subproduct berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data subproduct gagal disimpan! " + e.getMessage());
        }
    }

    public String deleteSubproduct(Integer id){
        try {
            Subproduct subproduct = subproductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data subproduct tidak ditemukan!"));
            subproductRepository.delete(subproduct);
            return "Data subproduct berhasil di hapus!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Data subproduct gagal dihapus!"  + e.getMessage());
        }
    }

    public List<SubproductRequest> getAllSubroducts(){
        List<Object[]> results = subproductRepository.findAllSubproductWithProductNameAndDeptName();
        return results.stream().map(result -> {
            SubproductRequest subprodReq = SubproductRequest.builder()
                                        .idSubproduct((Integer) result[0])
                                        .idProduct((Integer) result[1])
                                        .idDepartment((Integer) result[2])
                                        .subproductName((String) result[3])
                                        .productName((String) result[4])
                                        .departmentName((String) result[5])
                                        .build();
            return subprodReq;
        })
        .collect(Collectors.toList());
    }
}
