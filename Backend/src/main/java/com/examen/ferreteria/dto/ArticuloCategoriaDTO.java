package com.examen.ferreteria.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticuloCategoriaDTO {
    private String nombreArticulo;
    private String marca;
    private String nombreCategoria;
    private BigDecimal precio;
    private Integer stock;
}
