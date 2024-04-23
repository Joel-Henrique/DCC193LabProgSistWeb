package br.ufjf.scLab.model.repository;

import br.ufjf.scLab.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository< Cliente, Long> {
}
