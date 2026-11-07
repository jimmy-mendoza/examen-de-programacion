package com.examen.ferreteria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.examen.ferreteria.dto.ClienteFacturaDTO;
import com.examen.ferreteria.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Una fila por factura activa de un cliente activo, ordenada por fecha.
    @Query("SELECT new com.examen.ferreteria.dto.ClienteFacturaDTO(c.nombre, c.apellido, c.nit, f.fechaFactura, f.total) FROM Cliente c JOIN c.facturaList f WHERE c.estado = true AND f.estado = true ORDER BY f.fechaFactura ASC, f.idFactura ASC")
    List<ClienteFacturaDTO> reporteClienteFactura();
}
