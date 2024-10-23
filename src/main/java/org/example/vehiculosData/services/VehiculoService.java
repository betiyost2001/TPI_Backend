package org.example.vehiculosData.services;

import org.example.vehiculosData.models.Vehiculo;
import org.example.vehiculosData.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {
    private final VehiculoRepository repository;

    @Autowired
    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Vehiculo> getAll() {
        return repository.findAll();
    }

    public Vehiculo getById(Long id) throws ServiceException {
        return repository.findById(id).orElseThrow(() ->
                new ServiceException("Vehículo no encontrado"));
    }

    public Vehiculo create(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    public Vehiculo update(Long id, Vehiculo vehiculoDetails) throws ServiceException {
        Vehiculo vehiculo = repository.findById(id)
                .orElseThrow(() -> new ServiceException("Vehículo no encontrado"));

        vehiculo.setMarca(vehiculoDetails.getMarca());
        vehiculo.setModelo(vehiculoDetails.getModelo());
        vehiculo.setPatente(vehiculoDetails.getPatente());
        vehiculo.setKilometraje(vehiculoDetails.getKilometraje());

        return repository.save(vehiculo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
