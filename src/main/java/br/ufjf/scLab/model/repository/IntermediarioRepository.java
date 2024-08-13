package br.ufjf.scLab.model.repository;

import br.ufjf.scLab.model.entity.Intermediario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntermediarioRepository extends JpaRepository<Intermediario, Long> {
}
