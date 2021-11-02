package co.com.bancolombia.mongo;

import co.com.bancolombia.model.libro.Libro;
import co.com.bancolombia.model.libro.gateways.LibroRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Libro, Libro, String, MongoDBRepository> implements LibroRepository
// implements ModelRepository from domain
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Libro.class/* change for domain model */));
    }

    @Override
    public void guardarLibro(Libro libro) {
        this.repository.save(libro);
    }

    @Override
    public List<Libro> listarLibros() {
        return this.repository.findAll();
    }

    @Override
    public Libro obtenerLibro(String id) {
        return this.findById(id);
    }

    @Override
    public void eliminarLibro(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return this.repository.save(libro);
    }
}
