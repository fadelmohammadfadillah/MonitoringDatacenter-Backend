package com.collega.otomasi_datacenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubproductRequest {
    private Integer idSubproduct;
    private String subproductName;
    private Integer idProduct;
    private String productName;
    private Integer idDepartment;
    private String departmentName;
}
