package br.ufjf.scLab.api.dto;

import br.ufjf.scLab.model.entity.Automovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutomovelDto {

    private String placa;
    private String cor;
    private int numPortas;
    private String tipoCombustivel;
    private int quilometragem;
    private int ano;
    private String renavam;
    private String chassi;
    private String marca;
    private String modelo;
    private String estado;
    private String categoria;
    private List<Long> idsLocacoes;

    public static AutomovelDto create(Automovel automovel) {
        ModelMapper modelMapper = new ModelMapper();
        AutomovelDto dto = modelMapper.map(automovel, AutomovelDto.class);
        return dto;
    }
}
