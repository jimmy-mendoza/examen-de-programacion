package com.examen.ferreteria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examen.ferreteria.dto.ArticuloDTO;
import com.examen.ferreteria.dto.ArticuloCategoriaDTO;
import com.examen.ferreteria.service.ArticuloService;

@RestController
@RequestMapping({"/articulos", "/artículos"})
@CrossOrigin(origins = "*")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

    // Filtrar artículos activos por el texto recibido.
    @GetMapping("/mostrarActivosFiltro")
    public List<ArticuloDTO> mostrarActivosFiltro(@RequestParam(name = "nombre") String nombre) {
        return articuloService.mostrarActivosFiltro(nombre);
    }

    // Reporte de artículos con su categoría.
    @GetMapping("/reporteArticuloCategoria")
    public List<ArticuloCategoriaDTO> reporteArticuloCategoria() {
        return articuloService.reporteArticuloCategoria();
    }
}
