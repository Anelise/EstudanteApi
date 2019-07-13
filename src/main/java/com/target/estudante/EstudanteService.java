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

    public EstudanteDTO getEstudante(Long materia){
        Estudante est = repoEstudante.findByMatricula(materia);
        return new EstudanteDTO(est);
    }

    public void atualizaEstudante(Long matricula, EstudanteDTO estuPassado){
        Estudante estuAtualizado = repoEstudante.findByMatricula(matricula);
        estuAtualizado.setIdade(estuPassado.getIdade());
        estuAtualizado.setNome(estuPassado.getNome());
        estuAtualizado.setTurma(estuPassado.getTurma());

        repoEstudante.save(estuAtualizado);
    }

    public List<EstudanteDTO> getEstudantesPorNome(String nome){
        List<Estudante> estudantes = repoEstudante.findByNome(nome);
        List<EstudanteDTO> estudantesDTO = new ArrayList<>();

        for(Estudante estudante : estudantes ){
            estudantesDTO.add(new EstudanteDTO(estudante));
        }
        return estudantesDTO;
    }

    public void deleteEstudante(Long matricula){
        repoEstudante.deleteByMatricula(matricula);
    }

    public List<EstudanteDTO> getPorIntervaloMatricula(Long v1, Long v2){
        List<Estudante> estudantes = repoEstudante.findByMatriculaIntervalo(v1,v2);
        List<EstudanteDTO> estudantesDTO = new ArrayList<>();

        for(Estudante estudante : estudantes ){
            estudantesDTO.add(new EstudanteDTO(estudante));
        }
        return estudantesDTO;
    }
}
