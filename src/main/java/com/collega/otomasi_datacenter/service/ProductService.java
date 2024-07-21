package com.collega.otomasi_datacenter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Product;
import com.collega.otomasi_datacenter.repository.DepartmentRepository;
import com.collega.otomasi_datacenter.repository.ProductRepository;
import com.collega.otomasi_datacenter.vo.ProductRequest;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public String createProduct(ProductRequest request){
        try {
            Department department = departmentRepository.findById(request.getIdDepartment())
                .orElseThrow(() -> new RuntimeException("Data department tidak ditemukan!"));
            var product = Product.builder()
                            .productName(request.getProductName().toUpperCase())
                            .idDepartment(department)
                            .build();
            productRepository.save(product);
            return "Product baru berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Product baru gagal ditambahkan!" + e.getMessage());
        }
    }

    public String updateProduct(Integer id, ProductRequest request){
        try {
            Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data product tidak ditemukan!"));
            Department dept = departmentRepository.findById(request.getIdDepartment())
                .orElseThrow(() -> new RuntimeException("Data department tidak ditemukan!"));
            product.setProductName(request.getProductName().toUpperCase());
            product.setIdDepartment(dept);
            productRepository.save(product);
            return "Data perubahan product berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data product gagal disimpan!" + e.getMessage());
        }
    }

    public String deleteProduct(Integer id){
        try {
            Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data product tidak ditemukan!"));
            productRepository.delete(product);
            return "Data product berhasil di hapus!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Data product gagal dihapus!" + e.getMessage());
        }
    }

    public List<ProductRequest> getAllProducts(){
        List<Object[]> results = productRepository.findAllProductsWithDepartmentNames();
        return results.stream().map(result -> {
            ProductRequest prodReq = ProductRequest.builder()
                                        .idProduct((Integer) result[0])
                                        .idDepartment((Integer) result[1])
                                        .productName((String) result[2])
                                        .departmentName((String) result[3])
                                        .build();
            return prodReq;
        })
        .collect(Collectors.toList());
    }
}
