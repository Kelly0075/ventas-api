package com.sistemaventas.ventas_api.repository;

import com.sistemaventas.ventas_api.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
