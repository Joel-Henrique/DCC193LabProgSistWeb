package br.ufjf.scLab.api.controller;

import br.ufjf.scLab.api.dto.AutomovelDto;
import br.ufjf.scLab.model.entity.Automovel;
import br.ufjf.scLab.model.entity.AutomovelEstado;
import br.ufjf.scLab.service.AutomovelEstadoService;
import br.ufjf.scLab.service.AutomovelService;
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
@RequestMapping("/api/v1/automoveis")
@RequiredArgsConstructor
@CrossOrigin
public class AutomovelController {

    private AutomovelService automovelService;
    private LocacaoService locacaoService;
    private AutomovelEstadoService automovelEstadoService;
//    private final AutomovelService automovelService;
//    private final LocacaoService locacaoService;

    @GetMapping()
    public ResponseEntity get() {
        List<Automovel> automoveis = automovelService.getAutomoveis();
        return ResponseEntity.ok(automoveis.stream().map(AutomovelDto::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id) {
        Optional<Automovel> automovel = automovelService.getAutomovelByPlaca(id);
        return ResponseEntity.ok(automovel.stream().map(AutomovelDto::create));
    }

    @PostMapping()
    public ResponseEntity cadastrarAutomovel(@RequestBody AutomovelDto automovelDto) {
        return null;
    }

    private Automovel converterFromDto(AutomovelDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        Automovel automovel = modelMapper.map(dto, Automovel.class);
        if(automovel.getEstado() != null) {
            Optional<AutomovelEstado> estado = automovelEstadoService.getEstadoByString(automovel.getEstado().getEstado());

        }
        return automovel;
    }
}
