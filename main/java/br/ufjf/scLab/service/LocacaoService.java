package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Locacao;
import br.ufjf.scLab.model.repository.LocacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Locacao> getLocacoesByIds(List<Long> idsLocacoes) {
        List<Locacao> locacoes = new ArrayList<>();
        for (Long id : idsLocacoes) {
            Optional<Locacao> locacao = locacaoRepository.findById(id);
            locacao.ifPresent(locacoes::add);
        }
        return locacoes;
    }

    public Object getLocacoes() { return locacaoRepository.findAll(); }

    public Optional<Locacao> getLocacaoById(Long id) { return locacaoRepository.findById(id); }
}
