package br.ufjf.scLab.service;

import br.ufjf.scLab.model.entity.Cliente;
import br.ufjf.scLab.model.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<Cliente> getClientes() { return clienteRepository.findAll(); }

    public Optional<Cliente> getClienteById(Long id) { return clienteRepository.findById(id); }

    public void excluir(Cliente cliente) { clienteRepository.delete(cliente); }
}
