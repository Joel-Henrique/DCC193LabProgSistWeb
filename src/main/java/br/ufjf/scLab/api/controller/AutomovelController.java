package br.ufjf.scLab.api.controller;

import br.ufjf.scLab.api.dto.AutomovelDto;
import br.ufjf.scLab.model.entity.Automovel;
import br.ufjf.scLab.service.AutomovelService;
import br.ufjf.scLab.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/automoveis")
@RequiredArgsConstructor
public class AutomovelController {

    private final AutomovelService automovelService;
    private final LocacaoService locacaoService;

    @GetMapping()
    public ResponseEntity get() {
        List<Automovel> automoveis = automovelService.getAutomoveis();
        return ResponseEntity.ok(automoveis.stream().map(AutomovelDto::create).collect(Collectors.toList()));
    }
}
