package com.collega.otomasi_datacenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.collega.otomasi_datacenter.model.Department;
import com.collega.otomasi_datacenter.model.Divisi;
import com.collega.otomasi_datacenter.model.Operator;
import com.collega.otomasi_datacenter.model.ProductOwner;
import com.collega.otomasi_datacenter.model.Supervisor;
import com.collega.otomasi_datacenter.repository.DepartmentRepository;
import com.collega.otomasi_datacenter.repository.DivisiRepository;
import com.collega.otomasi_datacenter.repository.OperatorRepository;
import com.collega.otomasi_datacenter.repository.ProductOwnerRepository;
import com.collega.otomasi_datacenter.repository.SupervisorRepository;
import com.collega.otomasi_datacenter.vo.UserRequest;

@Service
public class UserService {
    @Autowired
    private ProductOwnerRepository productOwnerRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private SupervisorRepository supervisorRepository;
    @Autowired
    private DivisiRepository divisiRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String updateProductOwner(Integer id, UserRequest request){
        try {
            ProductOwner productOwner = productOwnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user product owner tidak ditemukan!"));
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Data divisi tidak tersedia!"));
            productOwner.setIdDivisi(divisi);
            productOwner.setName(request.getName());
            productOwner.setUsername(request.getUsername());
            productOwner.setPassword(passwordEncoder.encode(request.getPassword()));
            productOwner.setRole(request.getRole());
            if (request.getIdDepartment() != null){
                Department department = departmentRepository.findById(request.getIdDepartment())
                    .orElseThrow(() -> new RuntimeException("Data department tidak tersedia!"));
                productOwner.setIdDepartment(department);;
            }

            productOwnerRepository.save(productOwner);
            return "Data perubahan user product owner berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data user product owner gagal!");
        }
    }

    public String updateOperator(Integer id, UserRequest request){
        try {
            Operator operator = operatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("operator tidak ditemukan!"));
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Data divisi tidak tersedia!"));
            Department department = departmentRepository.findById(request.getIdDepartment())
                .orElseThrow(() -> new RuntimeException("Data department tidak tersedia!"));
            operator.setIdDepartment(department);
            operator.setIdDivisi(divisi);
            operator.setName(request.getName());
            operator.setUsername(request.getUsername());
            operator.setPassword(passwordEncoder.encode(request.getPassword()));

            operatorRepository.save(operator);
            return "Data perubahan user operator berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data user operator gagal!");
        }
    }

    public String updateSupervisor(Integer id, UserRequest request){
        try {
            Supervisor supervisor = supervisorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("operator tidak ditemukan!"));
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Data divisi tidak tersedia!"));
            Department department = departmentRepository.findById(request.getIdDepartment())
                .orElseThrow(() -> new RuntimeException("Data department tidak tersedia!"));
            supervisor.setIdDepartment(department);
            supervisor.setIdDivisi(divisi);
            supervisor.setName(request.getName());
            supervisor.setUsername(request.getUsername());
            supervisor.setPassword(passwordEncoder.encode(request.getPassword()));

            supervisorRepository.save(supervisor);
            return "Data perubahan user supervisor berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data user supervisor gagal!");
        }
    }

    public String deleteProductOwner(Integer id){
        try {
            ProductOwner productOwner = productOwnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User product owner tidak ditemukan!"));
            productOwnerRepository.delete(productOwner);
            return "Data product owner berhasil di hapus!";
        }catch (RuntimeException e) {
            throw new RuntimeException("Data product owner tidak dapat ditemukan");
        }
    }

    public String deleteSupervisor(Integer id){
        try {
            Supervisor supervisor = supervisorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User supervisor tidak ditemukan!"));
            supervisorRepository.delete(supervisor);
            return "Data supervisor berhasil di hapus!";
        }catch (RuntimeException e) {
            throw new RuntimeException("Data supervisor tidak dapat ditemukan");
        }
    }

    public String deleteOperator(Integer id){
        try {
            Operator operator = operatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User operator tidak ditemukan!"));
                operatorRepository.delete(operator);
            return "Data operator berhasil di hapus!";
        }catch (RuntimeException e) {
            throw new RuntimeException("Data operator tidak dapat ditemukan");
        }
    }

    public List<UserRequest> getAllUsers(){
        List<UserRequest> users = new ArrayList<>();

        List<Object[]> productOwners = productOwnerRepository.findAllPOWithDeptNameAndDivName();
        users.addAll(productOwners.stream().map(po -> {
            UserRequest userPO = UserRequest.builder()
                                .idPO((Integer) po[0])
                                .idDepartment((Integer) po[1])
                                .idDivisi((Integer) po[2])
                                .name((String) po[3])
                                .username((String) po[4])
                                .password((String) po[5])
                                .role((String) po[6])
                                .departmentName((String) po[7])
                                .divisiName((String) po[8])
                                .build();
            return userPO;
        }).collect(Collectors.toList()));

        List<Object[]> operators = operatorRepository.findAllOperatorWithDeptAndDiv();
        users.addAll(operators.stream().map(op -> {
            UserRequest userOp = UserRequest.builder()
                                .idOperator((Integer) op[0])
                                .idDepartment((Integer) op[1])
                                .idDivisi((Integer) op[2])
                                .name((String) op[3])
                                .username((String) op[4])
                                .password((String) op[5])
                                .role("OPERATOR")
                                .departmentName((String) op[6])
                                .divisiName((String) op[7])
                                .build();
            return userOp;
        }).collect(Collectors.toList()));
    
        List<Object[]> supervisors = supervisorRepository.findAllSpvWithDeptAndDiv();
        users.addAll(supervisors.stream().map(spv -> {
            UserRequest userSpv = UserRequest.builder()
                                .idSupervisor((Integer) spv[0])
                                .idDepartment((Integer) spv[1])
                                .idDivisi((Integer) spv[2])
                                .name((String) spv[3])
                                .username((String) spv[4])
                                .password((String) spv[5])
                                .role("SUPERVISOR")
                                .departmentName((String) spv[6])
                                .divisiName((String) spv[7])
                                .build();
            return userSpv;
        }).collect(Collectors.toList()));
        return users;
    }
}
