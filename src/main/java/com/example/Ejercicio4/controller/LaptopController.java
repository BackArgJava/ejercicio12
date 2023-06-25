package com.example.Ejercicio4.controller;

import com.example.Ejercicio4.entities.Laptop;
import com.example.Ejercicio4.repository.LaptopRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class   LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    //atributos

    private LaptopRepository laptopRepository;

    //constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptop")
    // recuperar y devolver  las laptops  de base de datos
    public List<Laptop> findAll() {
       return laptopRepository.findAll();
    }


    /**
     * http://localhost:8080/api/laptops/1
     * http://localhost:8080/api/laptops/2
     * Request
     * Response
     * @param id
     * @return
     */

    // buscar un solo libro en base de datos segun su id
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneByID(@ApiParam("Clave primaria tipo Long") @PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id); // 4654654648
        // opcion 1
        if(laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

    }
    /**
     * actualizar un libro existente en base de datos
     */
     @PutMapping("/api/laptop")
     public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
      if(laptop.getId() == null) { // si no tiene id quiere decir que sí es una creación
          log.warn("Trying to update a non existent laptop");
          return ResponseEntity.notFound().build();
      }
      if(!laptopRepository.existsById(laptop.getId())){
       log.warn("Trying to update a non existent laptop");
       return ResponseEntity.notFound().build();
      }
         // El proceso de actualización
       Laptop result = laptopRepository.save(laptop);
       return ResponseEntity.ok(result);  // la laptop devuelta tiene una clave primaria

     }








    //CREAR un nuevo libro en base de datos
    //postman es para enviar datos(del postman al intelli j)
    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        return laptopRepository.save(laptop);


    }
    @ApiIgnore // ignorar este método para que no aparezca en la documentación de la api Swagger
    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop>deleteAll(){
        log.info("REST Request for delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();


    }

}
