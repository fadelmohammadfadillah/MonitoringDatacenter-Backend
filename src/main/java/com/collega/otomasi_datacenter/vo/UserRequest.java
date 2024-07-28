package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Integer idPO;
    private Integer idOperator;
    private Integer idSupervisor;
    private Integer idDepartment;
    private Integer idDivisi;
    private String name;
    private String username;
    private String password;
    private String role;
    private String departmentName;
    private String divisiName;
}
