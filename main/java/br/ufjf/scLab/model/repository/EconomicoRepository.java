package br.ufjf.scLab.model.repository;

import br.ufjf.scLab.model.entity.Economico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicoRepository extends JpaRepository<Economico, Long> {
}
