package com.collega.otomasi_datacenter.auth;

import com.collega.otomasi_datacenter.vo.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String username;
    private String password;
    private UserType userType;
    private Integer idDepartment;
    private Integer idDivisi;
}


