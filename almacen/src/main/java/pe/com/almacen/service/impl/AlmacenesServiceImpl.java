package pe.com.almacen.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.almacen.entity.AlmacenesEntity;
import pe.com.almacen.repository.AlmacenesRepository;
import pe.com.almacen.service.AlmacenesService;

@Service
public class AlmacenesServiceImpl implements AlmacenesService {

    @Autowired
    private AlmacenesRepository almacenRepository;

    @Override
    public List<AlmacenesEntity> findAll() {
        return almacenRepository.findAll();
    }

    @Override
    public List<AlmacenesEntity> findAllCustom() {
        return almacenRepository.findAllCustom();
    }

    @Override
    public AlmacenesEntity findById(Integer id) {
        Optional<AlmacenesEntity> almacen = almacenRepository.findById(id);
        return almacen.orElse(null);
    }

    @Override
    public AlmacenesEntity save(AlmacenesEntity almacen) {
        return almacenRepository.save(almacen);
    }

    @Override
    public AlmacenesEntity update(AlmacenesEntity almacen) {
        return almacenRepository.save(almacen);
    }

    @Override
    public void delete(Integer id) {
        AlmacenesEntity almacen = findById(id);
        if (almacen != null) {
            almacen.setEstado(0); // eliminado lógico
            almacenRepository.save(almacen);
        }
    }
}
