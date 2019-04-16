package com.almacen.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.almacen.model.Maestra;

public interface MaestraRepository extends JpaRepository<Maestra, String> {

    @Query(value = "SELECT m FROM Maestra m WHERE "
            + "(m.maeCodigo = :maeCodigo OR -1 = :maeCodigo) AND "
            + "m.maeDeslar LIKE :maeDeslar AND "
            + "(m.almMarca.marMarca = :almMarca OR -1 = :almMarca)")
    Page<Maestra> findByPageable(
          @Param("maeCodigo") Long maeCodigo
        , @Param("maeDeslar") String maeDeslar
        , @Param("almMarca") Long almMarca
        , Pageable page);
}
