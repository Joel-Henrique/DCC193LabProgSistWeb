package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Automovel;
import br.ufjf.scLab.model.repository.AutomovelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovelService {

    private AutomovelRepository automovelRepository;

    public AutomovelService(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    @Transactional
    public void excluir(String id) {
        automovelRepository.deleteById(id);
    }

    @Transactional
    public Automovel salvar(Automovel automovel) {
        return automovelRepository.save(automovel);
    }

    @Transactional
    public Automovel atualizar(Automovel automovel) { return automovelRepository.save(automovel); }

    @Transactional
    public List<Automovel> getAutomoveis() { return automovelRepository.findAll(); }

}
