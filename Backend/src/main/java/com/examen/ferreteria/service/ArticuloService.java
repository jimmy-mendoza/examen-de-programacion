package com.examen.ferreteria.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.examen.ferreteria.dto.ArticuloDTO;
import com.examen.ferreteria.dto.ArticuloCategoriaDTO;
import com.examen.ferreteria.entity.Articulo;
import com.examen.ferreteria.repository.ArticuloRepository;

@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // Consultar artículos activos que contengan el nombre recibido.
    public List<ArticuloDTO> mostrarActivosFiltro(String nombre) {
        return articuloRepository.findByEstadoTrueAndNombreContainingIgnoreCaseOrderByNombreAsc(nombre).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<ArticuloCategoriaDTO> reporteArticuloCategoria() {
        return articuloRepository.reporteArticuloCategoria();
    }

    // Convertir la entidad al formato que consume el frontend.
    private ArticuloDTO convertToDTO(Articulo articulo) {
        ArticuloDTO dto = new ArticuloDTO();
        dto.setIdArticulo(articulo.getIdArticulo());
        dto.setEstado(articulo.getEstado());
        dto.setNombre(articulo.getNombre());
        dto.setMarca(articulo.getMarca());
        dto.setPrecio(articulo.getPrecio());
        dto.setStock(articulo.getStock());
        dto.setIdCategoria(articulo.getIdCategoria() != null ? articulo.getIdCategoria().getIdCategoria() : null);
        return dto;
    }
}
