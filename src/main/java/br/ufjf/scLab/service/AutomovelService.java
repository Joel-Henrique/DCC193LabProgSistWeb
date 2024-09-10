package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Automovel;
import br.ufjf.scLab.model.repository.AutomovelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<Automovel> getAutomoveis() { return automovelRepository.findAll(); }

    public Optional<Automovel> getAutomovelByPlaca(String id) { return automovelRepository.findById(id); }
}
