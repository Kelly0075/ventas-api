package com.sistemaventas.ventas_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Lo siguiente es como cada renglón de una factura

    //Venta Muchos detalles pueden estar asociados a una venta
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="ventaId")
    private Venta venta;

    //Producto  Muchos detalles pueden estar asociados a un producto
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="productoId")
    private Producto prod;
    private Integer cantProd;
    private Double precio;
}
