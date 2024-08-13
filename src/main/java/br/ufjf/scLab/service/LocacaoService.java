package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Locacao;
import br.ufjf.scLab.model.repository.LocacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {

    private LocacaoRepository locacaoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Transactional
    public void excluir(Long id) {
        locacaoRepository.deleteById(id);
    }

    @Transactional
    public Locacao salvar(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }
}
