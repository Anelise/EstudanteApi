package com.target.estudante;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudanteController {
    @Autowired
    private EstudanteService service;

    @ApiOperation( value="Obtém a lista de Estudantes", response=Iterable.class, tags="getTodosEstudantes")
    @GetMapping("/estudantes")
    public List<EstudanteDTO> getTodosEstudantes(){
        return service.buscaTodos();
    }

    @ApiOperation( value="Cria estudante", tags="addEstudante" )
    @PostMapping("/estudante")
    public void addEstudante(@RequestBody EstudanteDTO m){
        service.addEstudante(m);
    }

    @ApiOperation( value="Vincula estudante materia", tags="addEstudanteMateria" )
    @PostMapping("/estudante/{id}/materia")
    public void addEstudanteMateria(@RequestBody List<Long> listaIds, @PathVariable("id") Long matricula){
        service.addEstudanteMateria(listaIds,matricula);
    }



}
