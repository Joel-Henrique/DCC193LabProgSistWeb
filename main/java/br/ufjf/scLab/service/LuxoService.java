package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Luxo;
import br.ufjf.scLab.model.repository.LuxoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LuxoService {

    private LuxoRepository luxoRepository;

    public LuxoService(LuxoRepository luxoRepository) {
        this.luxoRepository = luxoRepository;
    }

    @Transactional
    public void excluir(Long id) {
        luxoRepository.deleteById(id);
    }

    @Transactional
    public Luxo salvar(Luxo luxo) {
        return luxoRepository.save(luxo);
    }

}
