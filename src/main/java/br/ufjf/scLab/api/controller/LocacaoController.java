package br.ufjf.scLab.api.controller;

import br.ufjf.scLab.api.dto.LocacaoDto;
import br.ufjf.scLab.model.entity.Locacao;
import br.ufjf.scLab.service.AutomovelService;
import br.ufjf.scLab.service.ClienteService;
import br.ufjf.scLab.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
        return ResponseEntity.ok(locacaoService.getLocacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(Long id) {
        Optional<Locacao> locacao = locacaoService.getLocacaoById(id);
        return ResponseEntity.ok(locacao.stream().map(LocacaoDto::create));
    }

    //todo: implementar métodos de cadastro e atualização de locação

}
