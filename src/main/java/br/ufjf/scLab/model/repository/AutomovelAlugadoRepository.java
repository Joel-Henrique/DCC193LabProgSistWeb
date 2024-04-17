package br.ufjf.scLab.model.repository;

import br.ufjf.scLab.model.entity.AutomovelAlugado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelAlugadoRepository extends JpaRepository<AutomovelAlugado, Integer> {
}
