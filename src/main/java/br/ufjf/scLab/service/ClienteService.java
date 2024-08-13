package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Cliente;
import br.ufjf.scLab.model.repository.ClienteRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
