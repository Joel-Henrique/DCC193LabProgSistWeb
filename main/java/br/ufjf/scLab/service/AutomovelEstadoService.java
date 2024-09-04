package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.AutomovelEstado;
import br.ufjf.scLab.model.repository.AutomovelEstadoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutomovelEstadoService {

    private AutomovelEstadoRepository automovelEstadoRepository;

    public AutomovelEstadoService(AutomovelEstadoRepository automovelEstadoRepository) { this.automovelEstadoRepository = automovelEstadoRepository; }

    public Optional<AutomovelEstado> getEstadoById(Long id) { return automovelEstadoRepository.findById(id); }

    public Optional<AutomovelEstado> getEstadoByString(String estado) { return automovelEstadoRepository.findByEstado(estado); }
}
