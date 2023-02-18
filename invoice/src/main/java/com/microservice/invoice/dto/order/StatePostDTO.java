package com.microservice.invoice.dto.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatePostDTO {
    private Integer id;
    @NotBlank
    private String state;
}
