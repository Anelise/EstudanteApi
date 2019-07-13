package com.target.estudante;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="EstudanteController", description = "Controladora de estudantes")
@RestController
public class EstudanteController {
    @Autowired
    private EstudanteService service;

    @ApiOperation( value="Obtém a lista de Estudantes", response=Iterable.class, tags="getTodosEstudantes")
    @ApiResponses( value = {
            @ApiResponse(code =200, message="Sucesso", response = EstudanteDTO.class),
            @ApiResponse(code =500, message="Erro", response = Exception.class)
    })
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

    @ApiOperation( value="Obtém estudante por matricula", response=EstudanteDTO.class, tags="getEstudantePorMatricula" )
    @GetMapping("/estudante/{matricula}")
    public EstudanteDTO getEstudantePorMatricula(@PathVariable("matricula") Long matricula){
        return service.getEstudante(matricula);
    }

    @ApiOperation(value="Atualiza estudante (não altera matriculas)", tags="atualizaEstudante")
    @PutMapping("/estudante/{matricula}")
    public void atualizaEstudante(@PathVariable("matricula") Long matricula, @RequestBody EstudanteDTO estudante){
        service.atualizaEstudante(matricula,estudante);
    }

    @ApiOperation(value="deleta um estudante por matricula", tags="deletaEstudante")
    @DeleteMapping("/estudante/{matricula}")
    public void deletaEstudante(@PathVariable("matricula") Long matricula){
        service.deleteEstudante(matricula);
    }

    @ApiOperation(value="busca todos os estudantes com um certo nome",response=Iterable.class,tags="getEstudantesPorNome" )
    @GetMapping("/estudante/pornome/{nome}")
    public List<EstudanteDTO> getEstudantesPorNome(@PathVariable("nome") String nome){
        return service.getEstudantesPorNome(nome);
    }

    //produto?v1=1&v2=3
    @ApiOperation(value="pega estudantes com intervalo de matricula", response = Iterable.class, tags="getPorMatriculaIntervalo")
    @GetMapping("/estudante/porintervalo/")
    public List<EstudanteDTO> getPorMatriculaIntervalo(@RequestParam Long v1,@RequestParam Long v2){
        return service.getPorIntervaloMatricula(v1,v2);
    }
}
