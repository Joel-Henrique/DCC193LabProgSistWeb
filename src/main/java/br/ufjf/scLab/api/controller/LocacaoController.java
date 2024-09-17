package br.ufjf.scLab.api.controller;

import br.ufjf.scLab.api.dto.LocacaoDto;
import br.ufjf.scLab.model.entity.Automovel;
import br.ufjf.scLab.model.entity.AutomovelEstado;
import br.ufjf.scLab.model.entity.Cliente;
import br.ufjf.scLab.model.entity.Locacao;
import br.ufjf.scLab.service.AutomovelService;
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
@RequestMapping("/api/v1/locacoes")
@RequiredArgsConstructor
@CrossOrigin
public class LocacaoController {

    private final LocacaoService locacaoService;
    private final AutomovelService automovelService;
    private final ClienteService clienteService;

    @GetMapping()
    public ResponseEntity get() {
        List<Locacao> locacoes = locacaoService.getLocacoes();
        return ResponseEntity.ok(locacoes.stream().map(LocacaoDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(Long id) {
        Optional<Locacao> locacao = locacaoService.getLocacaoById(id);
        return ResponseEntity.ok(locacao.stream().map(LocacaoDto::create));
    }

    //todo: implementar métodos de cadastro e atualização de locação
    @PostMapping("/cadastrarLocacao")
    public ResponseEntity post(@RequestBody LocacaoDto locacaoDto) {
        try {
            Locacao locacao = this.converterFromDto(locacaoDto);
            locacao = locacaoService.salvar(locacao);
            automovelService.atualizar(locacao.getAutomovel());
            return new ResponseEntity(locacao, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Locacao converterFromDto(LocacaoDto locacaoDto) {
//        ModelMapper modelMapper = new ModelMapper();
//        Locacao locacao = modelMapper.map(locacaoDto, Locacao.class);
        Locacao locacao = new Locacao();
        locacao.setId(locacaoDto.getId());
        locacao.setDataLocacao(locacaoDto.getDataLocacao());
        locacao.setDataDevolucao(locacaoDto.getDataDevolucao());
        locacao.setQuilometragemInicial(locacaoDto.getQuilometragemInicial());
        locacao.setQuilometragemFinal(locacaoDto.getQuilometragemFinal());
        locacao.setValorLocacao(locacaoDto.getValorLocacao());
        locacao.setFinalizada(locacaoDto.isFinalizada() ? 1 : 0);
        if(locacaoDto.getPlacaAutomovel() != null) {
            Optional<Automovel> automovel = automovelService.getAutomovelByPlaca(locacaoDto.getPlacaAutomovel());
            if(automovel.isPresent()) {
                locacao.setAutomovel(automovel.get());
                locacao.getAutomovel().setEstado(new AutomovelEstado(2L, "alugado"));
            }
            else {
                throw new RuntimeException("Automóvel não encontrado");
            }
        }

        if (locacaoDto.getIdCliente() != null) {
            Optional<Cliente> cliente = clienteService.getClienteById(locacaoDto.getIdCliente());
            if (cliente.isPresent()) {
                locacao.setCliente(cliente.get());
            } else {
                throw new RuntimeException("Cliente não encontrado");
            }
        }

        return locacao;
    }

}
