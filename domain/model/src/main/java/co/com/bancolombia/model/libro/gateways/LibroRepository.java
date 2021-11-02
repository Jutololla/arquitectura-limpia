package co.com.bancolombia.model.libro.gateways;

import co.com.bancolombia.model.libro.Libro;

import java.util.List;

public interface LibroRepository {

    void guardarLibro(Libro libro);

    List<Libro> listarLibros();

    Libro obtenerLibro(String id);

    void eliminarLibro(String id);

    Libro actualizarLibro(Libro libro);
}
