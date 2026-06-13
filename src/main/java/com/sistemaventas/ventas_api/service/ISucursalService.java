package com.sistemaventas.ventas_api.service;

import com.sistemaventas.ventas_api.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {

    List<SucursalDTO> traerSucursales();
    SucursalDTO crearSucursal(SucursalDTO sucursalDto);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDto);
    void eliminarSucursal(Long id);
}
