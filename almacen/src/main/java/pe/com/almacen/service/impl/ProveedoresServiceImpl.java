package pe.com.almacen.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.almacen.entity.ProveedoresEntity;
import pe.com.almacen.repository.ProveedoresRepository;
import pe.com.almacen.service.ProveedoresService;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedorRepository;

    @Override
    public List<ProveedoresEntity> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public List<ProveedoresEntity> findAllCustom() {
        return proveedorRepository.findAllCustom();
    }

    @Override
    public ProveedoresEntity findById(Integer id) {
        Optional<ProveedoresEntity> proveedor = proveedorRepository.findById(id);
        return proveedor.orElse(null);
    }

    @Override
    public ProveedoresEntity save(ProveedoresEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public ProveedoresEntity update(ProveedoresEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void delete(Integer id) {
        ProveedoresEntity proveedor = findById(id);
        if (proveedor != null) {
            proveedor.setEstado(0); // eliminado lógico
            proveedorRepository.save(proveedor);
        }
    }
}
