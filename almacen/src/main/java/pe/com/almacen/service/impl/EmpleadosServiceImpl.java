package pe.com.almacen.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.almacen.entity.EmpleadosEntity;
import pe.com.almacen.repository.EmpleadosRepository;
import pe.com.almacen.service.EmpleadosService;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

    @Autowired
    private EmpleadosRepository empleadoRepository;

    @Override
    public List<EmpleadosEntity> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<EmpleadosEntity> findAllCustom() {
        return empleadoRepository.findAllCustom();
    }

    @Override
    public EmpleadosEntity findById(Integer id) {
        Optional<EmpleadosEntity> empleado = empleadoRepository.findById(id);
        return empleado.orElse(null);
    }

    @Override
    public EmpleadosEntity save(EmpleadosEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadosEntity update(EmpleadosEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void delete(Integer id) {
        EmpleadosEntity empleado = findById(id);
        if (empleado != null) {
            empleado.setEstado(0); // eliminado lógico
            empleadoRepository.save(empleado);
        }
    }
}
