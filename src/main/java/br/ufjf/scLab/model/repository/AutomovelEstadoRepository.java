package br.ufjf.scLab.model.repository;

import br.ufjf.scLab.model.entity.AutomovelEstado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutomovelEstadoRepository extends JpaRepository<AutomovelEstado, Long> {
    Optional<AutomovelEstado> findByEstado(String estado);
}
