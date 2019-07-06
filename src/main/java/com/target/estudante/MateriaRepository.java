package com.target.estudante;


import com.target.estudante.domain.Materia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MateriaRepository extends CrudRepository<Materia,Long> {
    public List<Materia> findByNome(String nome);

    @Query("select p from Materia p where p.codigo >= :v1 and p.codigo <= :v2")
    List<Materia> findByCodigoIntervalo(@Param("v1") Double v1, @Param("v2") Double v2);

    Materia findByCodigo(Long codigo);
}
