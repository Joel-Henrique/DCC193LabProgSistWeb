package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Intermediario;
import br.ufjf.scLab.model.repository.IntermediarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IntermediarioService {

    private IntermediarioRepository intermediarioRepository;

    public IntermediarioService(IntermediarioRepository intermediarioRepository) {
        this.intermediarioRepository = intermediarioRepository;
    }

    @Transactional
    public void excluir(Long id) {
        intermediarioRepository.deleteById(id);
    }

    @Transactional
    public Intermediario salvar(Intermediario intermediario) {
        return intermediarioRepository.save(intermediario);
    }

}
