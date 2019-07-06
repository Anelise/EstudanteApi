package com.target.estudante;

import com.target.estudante.domain.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository repo;

    public List<MateriaDTO> buscaTodos(){
        List<Materia> materias= (List<Materia>)repo.findAll();
        List<MateriaDTO> materiasDTO = new ArrayList<MateriaDTO>();

        for(Materia e1 : materias){
            materiasDTO.add(new MateriaDTO(e1));
        }
        return materiasDTO;
    }

    public void addMateria(MateriaDTO m){
        repo.save(m.converteMateria());
    }
}
