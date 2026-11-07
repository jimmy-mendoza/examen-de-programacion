package com.examen.ferreteria.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteFacturaDTO {
    private String nombre;
    private String apellido;
    private String nit;
    private Date fechaFactura;
    private BigDecimal total;
}
