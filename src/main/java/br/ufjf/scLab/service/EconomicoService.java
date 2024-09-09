package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Economico;
import br.ufjf.scLab.model.repository.EconomicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EconomicoService {

    private EconomicoRepository economicoRepository;

    public EconomicoService(EconomicoRepository economicoRepository) {
        this.economicoRepository = economicoRepository;
    }

    @Transactional
    public void excluir(Long id) {
        economicoRepository.deleteById(id);
    }

    @Transactional
    public Economico salvar(Economico economico) {
        return economicoRepository.save(economico);
    }

}
