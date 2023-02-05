package com.microservice.client.dto;

import com.microservice.client.entity.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String document;
    private String phone;
}
