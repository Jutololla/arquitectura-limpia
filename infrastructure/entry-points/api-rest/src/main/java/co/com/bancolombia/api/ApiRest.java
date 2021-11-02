package co.com.bancolombia.api;
import co.com.bancolombia.model.libro.Libro;
import co.com.bancolombia.usecase.libro.LibroUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
   private final LibroUseCase useCase;

   @PostMapping("/save")
   public String save(@RequestBody Libro libro){
      useCase.guardarLibro(libro);
      return "Libro guardado";
   }

   @GetMapping("/get")
   public List<Libro> findAll() {
      return useCase.listarLibros();
   }

   @GetMapping("/get/{id}")
   public Libro finduser(@PathVariable(value = "id") String id) {
      return useCase.obtenerLibro(id);
   }

   @PostMapping("/update/{id}")
   public String update(@RequestBody Libro libro){
      useCase.actualizarLibro(libro);
      return "Libro actualizado";
   }

   @PutMapping("/edit/{id}")
   public ResponseEntity<Libro> edit(@RequestBody Libro libro){
      if(!libro.getId().isEmpty()){
         return new ResponseEntity(useCase.actualizarLibro(libro), HttpStatus.OK);
      }
      return new ResponseEntity(HttpStatus.NOT_FOUND);
   }

   @DeleteMapping("/delete/{id}")
   public String delete(@PathVariable(value = "id") String id){
      useCase.eliminarLibro(id);
      return "Libro borrado";
   }

}
