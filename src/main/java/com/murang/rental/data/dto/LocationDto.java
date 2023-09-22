package com.murang.rental.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LocationDto {

    private String sido;

    private String sigugun;

    private String bname;
}
