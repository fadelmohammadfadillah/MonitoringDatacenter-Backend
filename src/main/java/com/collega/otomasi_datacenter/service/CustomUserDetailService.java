package com.collega.otomasi_datacenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Manager;
import com.collega.otomasi_datacenter.model.Operator;
import com.collega.otomasi_datacenter.model.SuperAdmin;
import com.collega.otomasi_datacenter.model.Supervisor;
import com.collega.otomasi_datacenter.model.UserDepartment;
import com.collega.otomasi_datacenter.model.UserDivisi;
import com.collega.otomasi_datacenter.repository.ManagerRepository;
import com.collega.otomasi_datacenter.repository.OperatorRepository;
import com.collega.otomasi_datacenter.repository.SuperAdminRepository;
import com.collega.otomasi_datacenter.repository.SupervisorRepository;
import com.collega.otomasi_datacenter.repository.UserDeptRepository;
import com.collega.otomasi_datacenter.repository.UserDivRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private SuperAdminRepository superAdminRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private SupervisorRepository supervisorRepository;
    @Autowired
    private UserDeptRepository userDeptRepository;
    @Autowired
    private UserDivRepository userDivRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SuperAdmin> superAdmin = Optional.ofNullable(superAdminRepository.findByUsername(username));
        if(superAdmin.isPresent()){
            return superAdmin.get();
        }

        Optional<Operator> operator = Optional.ofNullable(operatorRepository.findByUsername(username));
        if(operator.isPresent()){
            return operator.get();
        }

        Optional<Manager> manager = Optional.ofNullable(managerRepository.findByUsername(username));
        if(manager.isPresent()){
            return manager.get();
        }

        Optional<Supervisor> supervisor = Optional.ofNullable(supervisorRepository.findByUsername(username));
        if(supervisor.isPresent()){
            return supervisor.get();
        }

        Optional<UserDepartment> userDept = Optional.ofNullable(userDeptRepository.findByUsername(username));
        if(userDept.isPresent()){
            return userDept.get();
        }

        Optional<UserDivisi> userDiv = Optional.ofNullable(userDivRepository.findByUsername(username));
        if(userDiv.isPresent()){
            return userDiv.get();
        }
        throw new UsernameNotFoundException("User not found !");
    }
    
}
