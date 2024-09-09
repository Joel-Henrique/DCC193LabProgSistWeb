package br.ufjf.scLab.api.controller;

import br.ufjf.scLab.api.dto.ClienteDto;
import br.ufjf.scLab.model.entity.Cliente;
import br.ufjf.scLab.model.entity.Locacao;
import br.ufjf.scLab.service.ClienteService;
import br.ufjf.scLab.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
@CrossOrigin
public class ClienteController {

    private final ClienteService clienteService;
    private final LocacaoService locacaoService;

    @GetMapping()
    public ResponseEntity get() {
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes.stream().map(ClienteDto::create).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente.stream().map(ClienteDto::create));
    }

    @PostMapping()
    public ResponseEntity cadastrarCliente(@RequestBody ClienteDto clienteDto) {
        try {
            Cliente cliente = this.converterFromDto(clienteDto);
            cliente = clienteService.salvar(cliente);
            return new ResponseEntity(cliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody ClienteDto clienteDto) {
        if (!clienteService.getClienteById(id).isPresent()) {
            return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Cliente cliente = this.converterFromDto(clienteDto);
            cliente.setId(id);
            cliente = clienteService.salvar(cliente);
            return new ResponseEntity(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (!cliente.isPresent()) {
            return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            clienteService.excluir(cliente.get());
            return new ResponseEntity("Cliente excluído com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Cliente converterFromDto(ClienteDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        if (dto.getIdsLocacoes() != null) {
            List<Locacao> locacoes = locacaoService.getLocacoesByIds(dto.getIdsLocacoes());
            cliente.setLocacoes(locacoes);
        }
        return cliente;
    }

}
