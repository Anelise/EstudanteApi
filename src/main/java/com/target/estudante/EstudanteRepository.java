package com.target.estudante;

import com.target.estudante.domain.Estudante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudanteRepository extends CrudRepository<Estudante,Long> {
    public List<Estudante> findByNome(String nome);

    @Query("select p from Estudante p where p.matricula >= :v1 and p.matricula <= :v2")
    List<Estudante> findByMatriculaIntervalo(@Param("v1") Long v1, @Param("v2") Long v2);

    Estudante findByMatricula(Long matricula);

    public void deleteByMatricula(Long matricula);
}
