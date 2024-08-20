package br.ufjf.scLab.api.controller;

import br.ufjf.scLab.api.dto.AutomovelDto;
import br.ufjf.scLab.model.entity.Automovel;
import br.ufjf.scLab.model.entity.AutomovelEstado;
import br.ufjf.scLab.model.entity.CategoriaAutomovel;
import br.ufjf.scLab.model.entity.Locacao;
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

//    private AutomovelService automovelService;
//    private LocacaoService locacaoService;
//    private AutomovelEstadoService automovelEstadoService;
    private final AutomovelService automovelService;
    private final LocacaoService locacaoService;
    private final AutomovelEstadoService automovelEstadoService;

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
        try {
            Automovel automovel = this.converterFromDto(automovelDto);
            automovel = automovelService.salvar(automovel);
            return new ResponseEntity(automovel, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") String id, @RequestBody AutomovelDto automovelDto) {
        if (!automovelService.getAutomovelByPlaca(id).isPresent()) {
            return new ResponseEntity("Automóvel não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Automovel automovel = this.converterFromDto(automovelDto);
            automovel.setPlaca(id);
            automovel = automovelService.salvar(automovel);
            return new ResponseEntity(automovel, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable("id") String id) {
        Optional<Automovel> automovel = automovelService.getAutomovelByPlaca(id);
        if (!automovel.isPresent()) {
            return new ResponseEntity("Automóvel não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            if (automovel.get().getEstado().getEstado().equals("LOCADO")) {
                return new ResponseEntity("Automóvel não pode ser excluído, pois está em uma locação", HttpStatus.BAD_REQUEST);
            }
            automovelService.excluir(automovel.get().getPlaca());
            return new ResponseEntity("Automóvel excluído com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Automovel converterFromDto(AutomovelDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        Automovel automovel = modelMapper.map(dto, Automovel.class);
        if(dto.getEstado() != null) {
            Optional<AutomovelEstado> estado = automovelEstadoService.getEstadoByString(dto.getEstado());
            if(estado.isPresent()) {
                automovel.setEstado(estado.get());
            } else {
                automovel.setEstado(null);
            }

            List<Locacao> locacao = locacaoService.getLocacoesByIds(dto.getIdsLocacoes());
            automovel.setLocacoes(locacao);

            //todo: setar categoria
        }
        return automovel;
    }
}
