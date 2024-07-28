package com.collega.otomasi_datacenter.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.collega.otomasi_datacenter.vo.AuthenticationRequest;
import com.collega.otomasi_datacenter.vo.AuthenticationResponse;
import com.collega.otomasi_datacenter.vo.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final ProductOwnerRepository productOwnerRepository;
    private final DivisiRepository divisiRepository;
    private final DepartmentRepository departmentRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailService userDetailService;
    private final OperatorRepository operatorRepository;
    private final SupervisorRepository supervisorRepository;

    public String registerProductOwner(RegisterRequest request){
        try {
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Data divisi tidak tersedia!"));
            var productOwner = ProductOwner.builder()
                .idDivisi(divisi)
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
            if(request.getIdDepartment() != null){
                Department department = departmentRepository.findById(request.getIdDepartment())
                    .orElseThrow(() -> new RuntimeException("Data department tidak tersedia!"));
                productOwner.setIdDepartment(department);
            }
            productOwnerRepository.save(productOwner);
            return "Registrasi product owner " + request.getRole() +" berhasil!";
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }catch (RuntimeException e){
            throw new RuntimeException("Registrasi user gagal!", e);
        }
    }

    public String registerOperator(RegisterRequest request){
        try {
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Data divisi tidak tersedia!"));
            Department department = departmentRepository.findById(request.getIdDepartment())
                .orElseThrow(() -> new RuntimeException("Data department tidak tersedia!"));
            var operator = Operator.builder()
                .idDepartment(department)
                .idDivisi(divisi)
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
            operatorRepository.save(operator);
            return "Registrasi operator berhasil!";
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }catch (Exception e) {
            throw new RuntimeException("Registrasi user gagal!", e);
        }
    }

    public String registerSupervisor(RegisterRequest request){
        try {
            Divisi divisi = divisiRepository.findById(request.getIdDivisi())
                .orElseThrow(() -> new RuntimeException("Data divisi tidak tersedia!"));
            Department department = departmentRepository.findById(request.getIdDepartment())
                .orElseThrow(() -> new RuntimeException("Data department tidak tersedia!"));
            var supervisor = Supervisor.builder()
                .idDepartment(department)
                .idDivisi(divisi)
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
            supervisorRepository.save(supervisor);
            return "Registrasi supervisor berhasil!";
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Username tersebut sudah terpakai!", e);
        }catch (Exception e) {
            throw new RuntimeException("Registrasi user gagal!", e);
        }
    }    

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Username atau Password salah!", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return AuthenticationResponse.builder().jwtToken(jwt).build();
    }
}
