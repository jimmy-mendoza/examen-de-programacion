package com.examen.ferreteria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examen.ferreteria.dto.ClienteFacturaDTO;
import com.examen.ferreteria.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // Reporte de facturas activas por cliente.
    @GetMapping("/reporteClienteFactura")
    public List<ClienteFacturaDTO> reporteClienteFactura() {
        return clienteService.reporteClienteFactura();
    }
}
