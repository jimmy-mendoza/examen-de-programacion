package com.examen.ferreteria.dto;

import java.math.BigDecimal;
import lombok.Data;

// Datos del artículo sin exponer las relaciones de la entidad.
@Data
public class ArticuloDTO {
    private Integer idArticulo;
    private Boolean estado;
    private String nombre;
    private String marca;
    private BigDecimal precio;
    private Integer stock;
    private Integer idCategoria;
}
