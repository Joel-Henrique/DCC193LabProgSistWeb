package br.ufjf.scLab.model.repository;

import br.ufjf.scLab.model.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}
