package com.collega.otomasi_datacenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.collega.otomasi_datacenter.model.SuperAdmin;
import com.collega.otomasi_datacenter.model.Supervisor;
import com.collega.otomasi_datacenter.model.Operator;
import com.collega.otomasi_datacenter.model.ProductOwner;
import com.collega.otomasi_datacenter.repository.SuperAdminRepository;
import com.collega.otomasi_datacenter.repository.SupervisorRepository;
import com.collega.otomasi_datacenter.repository.OperatorRepository;
import com.collega.otomasi_datacenter.repository.ProductOwnerRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private SuperAdminRepository superAdminRepository;
    @Autowired
    private ProductOwnerRepository productOwnerRepository;
    @Autowired
    private SupervisorRepository supervisorRepository;
    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SuperAdmin> superAdmin = Optional.ofNullable(superAdminRepository.findByUsername(username));
        if(superAdmin.isPresent()){
            return superAdmin.get();
        }

        Optional<ProductOwner> productOwner = Optional.ofNullable(productOwnerRepository.findByUsername(username));
        if(productOwner.isPresent()){
            return productOwner.get();
        }

        Optional<Supervisor> supervisor = Optional.ofNullable(supervisorRepository.findByUsername(username));
        if(supervisor.isPresent()){
            return supervisor.get();
        }
        
        Optional<Operator> operator = Optional.ofNullable(operatorRepository.findByUsername(username));
        if(operator.isPresent()){
            return operator.get();
        }

        throw new UsernameNotFoundException("User not found !");
    }
    
}
