package com.microservice.service.dto;
import com.microservice.service.entity.Specialty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorPostDTO {
    private Integer id;
    private String document;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String image;
}
