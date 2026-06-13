package com.sistemaventas.ventas_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String estado;
    private Double total;
    @ManyToOne //Muchas ventas van a estar asociadas a cada sucursal
    private Sucursal sucursal; //Objeto de tipo sucursal

    @OneToMany (mappedBy = "venta", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleVenta> detalle = new ArrayList<>();
}
