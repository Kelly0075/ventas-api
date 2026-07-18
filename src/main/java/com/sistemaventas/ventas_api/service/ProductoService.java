package com.sistemaventas.ventas_api.service;

import com.sistemaventas.ventas_api.dto.ProductoDTO;
import com.sistemaventas.ventas_api.exception.NotFoundException;
import com.sistemaventas.ventas_api.mapper.Mapper;
import com.sistemaventas.ventas_api.model.Producto;
import com.sistemaventas.ventas_api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<ProductoDTO> traerProductos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {
        Producto prod = Producto.builder()
                .nombre(productoDto.getNombre())
                .categoria(productoDto.getCategoria())
                .precio(productoDto.getPrecio())
                .cantidad(productoDto.getCantidad())
                .build();
        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDto) {

        //buscar si existe el producto
        Producto prod = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        prod.setNombre(productoDto.getNombre());
        prod.setCategoria(productoDto.getCategoria());
        prod.setCantidad(productoDto.getCantidad());
        prod.setPrecio(productoDto.getPrecio());

        return Mapper.toDTO(repo.save(prod));

    }

    @Override
    public void eliminarProducto(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Producto no encontrado para eliminar");
        }

        repo.deleteById(id);
    }
}
