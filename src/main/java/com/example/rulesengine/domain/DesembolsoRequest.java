package com.example.rulesengine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DesembolsoRequest {
    private String documento;
    private Integer duracion;
    private Boolean desmebolso;
}
