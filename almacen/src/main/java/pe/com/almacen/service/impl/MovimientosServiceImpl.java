package pe.com.almacen.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.almacen.entity.MovimientosEntity;
import pe.com.almacen.repository.MovimientosRepository;
import pe.com.almacen.service.MovimientosService;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Override
    public List<MovimientosEntity> findAll() {
        return movimientosRepository.findAll();
    }

    @Override
    public MovimientosEntity findById(Integer id) {
        Optional<MovimientosEntity> movimiento = movimientosRepository.findById(id);
        return movimiento.orElse(null);
    }

    @Override
    public MovimientosEntity save(MovimientosEntity movimiento) {
        return movimientosRepository.save(movimiento);
    }

    @Override
    public MovimientosEntity update(MovimientosEntity movimiento) {
        return movimientosRepository.save(movimiento);
    }

    @Override
    public void delete(Integer id) {
        movimientosRepository.deleteById(id);
    }
}
