package com.target.estudante;

import com.target.estudante.domain.Materia;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation( value="Obtém materia por código", response=MateriaDTO.class, tags="getMateriaPorCodigo" )
    @GetMapping("/materia/{codigo}")
    public MateriaDTO getMateriaPorCodigo(@PathVariable Long codigo){
        return service.getMateriaPorCodigo(codigo);
    }


}
