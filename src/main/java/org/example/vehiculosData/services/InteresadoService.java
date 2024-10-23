package org.example.vehiculosData.services;

import org.example.vehiculosData.models.Interesados;
import org.example.vehiculosData.repositories.InteresadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteresadoService {
    private final InteresadoRepository repository;

    @Autowired
    public InteresadoService(InteresadoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Interesados> getAll() {
        return repository.findAll();
    }

    public Interesados getById(Long id) throws ServiceException {
        return repository.findById(id).orElseThrow(() ->
                new ServiceException("Cliente no encontrado"));
    }

    public List<Interesados> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public Interesados create(Interesados cliente) {
        return repository.save(cliente);
    }

    public Interesados update(Long id, Interesados clienteDetails) throws ServiceException {
        Interesados cliente = repository.findById(id)
                .orElseThrow(() -> new ServiceException("Cliente no encontrado"));

        cliente.setDocumento(clienteDetails.getDocumento());
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setLicenciaValidaHasta(clienteDetails.getLicenciaValidaHasta());

        return repository.save(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
