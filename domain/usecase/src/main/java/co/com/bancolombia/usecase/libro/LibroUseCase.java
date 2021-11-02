package co.com.bancolombia.usecase.libro;

import co.com.bancolombia.model.libro.Libro;
import co.com.bancolombia.model.libro.gateways.LibroRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LibroUseCase {
    private final LibroRepository libroRepository;

    public void guardarLibro(Libro libro){
        libroRepository.guardarLibro(libro);
    }

    public List<Libro> listarLibros(){
        return libroRepository.listarLibros();
    }

    public Libro obtenerLibro(String id){
        return libroRepository.obtenerLibro(id);
    }

    public void eliminarLibro(String id){
        libroRepository.eliminarLibro(id);
    }

    public Libro actualizarLibro(Libro libro){
        return libroRepository.actualizarLibro(libro);
    }

}
