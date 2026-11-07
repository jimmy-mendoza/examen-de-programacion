package com.examen.ferreteria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.examen.ferreteria.dto.ArticuloCategoriaDTO;
import com.examen.ferreteria.entity.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
    // Buscar artículos activos sin distinguir mayúsculas y minúsculas.
    List<Articulo> findByEstadoTrueAndNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

    // Incluir únicamente artículos y categorías activos, ordenados por categoría y nombre.
    @Query("SELECT new com.examen.ferreteria.dto.ArticuloCategoriaDTO(a.nombre, a.marca, c.nombre, a.precio, a.stock) FROM Articulo a JOIN a.idCategoria c WHERE a.estado = true AND c.estado = true ORDER BY c.nombre ASC, a.nombre ASC")
    List<ArticuloCategoriaDTO> reporteArticuloCategoria();
}
