package com.target.estudante;



import com.target.estudante.domain.Estudante;
import com.target.estudante.domain.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudanteService {
    @Autowired
    private EstudanteRepository repoEstudante;

    @Autowired
    private MateriaRepository repoMateria;

    public List<EstudanteDTO> buscaTodos(){
        List<Estudante> estudantes= (List<Estudante>)repoEstudante.findAll();
        List<EstudanteDTO> estudantesDTO = new ArrayList<EstudanteDTO>();

        for(Estudante e1 : estudantes){
            estudantesDTO.add(new EstudanteDTO(e1));
        }
        return estudantesDTO;
    }

    public void addEstudante(EstudanteDTO e){
        repoEstudante.save(e.converteEstudante());
    }

    public void addEstudanteMateria(List<Long> listaIds, Long matricula){
        Estudante estudante = repoEstudante.findByMatricula(matricula);

        if(estudante.getMaterias()== null){
            estudante.setMaterias(new ArrayList<>());
        }

        for(Long materiaId : listaIds ){
            Materia m =repoMateria.findByCodigo(materiaId);
            estudante.getMaterias().add(m);

        }

        repoEstudante.save(estudante);
    }
}
