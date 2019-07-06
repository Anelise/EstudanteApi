package com.target.estudante;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MateriaController {
    @Autowired
    private MateriaService service;

    @ApiOperation( value="Obtém a lista de Materias", response=Iterable.class, tags="getTodasMaterias")
    @GetMapping("/materias/")
    public List<MateriaDTO> getTodasMaterias(){
        return service.buscaTodos();
    }

    @ApiOperation( value="Cria materia", tags="addMateria" )
    @PostMapping("/materia")
    public void addMateria(@RequestBody MateriaDTO m){
        service.addMateria(m);
    }
}
