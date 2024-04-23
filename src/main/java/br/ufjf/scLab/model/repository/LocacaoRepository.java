package br.ufjf.scLab.model.repository;

import br.ufjf.scLab.model.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
