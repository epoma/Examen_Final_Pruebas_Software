package pe.com.almacen.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.almacen.entity.TipoMovimientoEntity;
import pe.com.almacen.repository.TipoMovimientoRepository;
import pe.com.almacen.service.TipoMovimientoService;

@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService {

    @Autowired
    private TipoMovimientoRepository tipoMovimientoRepository;

    @Override
    public List<TipoMovimientoEntity> findAll() {
        return tipoMovimientoRepository.findAll();
    }

    @Override
    public TipoMovimientoEntity findById(Integer id) {
        Optional<TipoMovimientoEntity> tipo = tipoMovimientoRepository.findById(id);
        return tipo.orElse(null);
    }

    @Override
    public TipoMovimientoEntity save(TipoMovimientoEntity tipoMovimiento) {
        return tipoMovimientoRepository.save(tipoMovimiento);
    }

    @Override
    public TipoMovimientoEntity update(TipoMovimientoEntity tipoMovimiento) {
        return tipoMovimientoRepository.save(tipoMovimiento);
    }

    @Override
    public void delete(Integer id) {
        tipoMovimientoRepository.deleteById(id);
    }
}
