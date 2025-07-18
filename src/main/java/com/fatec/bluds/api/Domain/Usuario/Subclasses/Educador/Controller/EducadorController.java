package com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador.Controller;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador.DTO.EducadorDetailsDTO;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador.DTO.EducarCreationDTO;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador.Service.EducadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("educador")
public class EducadorController {

    @Autowired
    private final EducadorService educadorService;

    public EducadorController(EducadorService educadorService) {
        this.educadorService = educadorService;
    }

    @PostMapping("/create")
    public ResponseEntity<> createEducador(@RequestBody @Valid EducarCreationDTO dto){

    }

    @PutMapping("/update")
    public ResponseEntity<EducadorDetailsDTO> updateEducador(){

    }

    @GetMapping("/{id}}")
    public ResponseEntity<EducadorDetailsDTO> getEducadorById(@PathVariable Long id){

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EducadorDetailsDTO> getEducadorByEmail(@PathVariable String email) {

    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<EducadorDetailsDTO> getEducadorByMatricula(@PathVariable String email) {

    }

    @GetMapping
    public ResponseEntity<List<EducadorDetailsDTO>> getAll(){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        
    }

}
