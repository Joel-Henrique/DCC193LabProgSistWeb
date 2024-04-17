package br.ufjf.scLab.api.dto;


import br.ufjf.scLab.model.entity.AutomovelAlugado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovelAlugadoDTO {

    private Long id;
    private String placa;
    private String cor;
    private int numeroPortas;
    private String tipoCombustivel;
    private long Kilometragem;
    private int ano;
    private String renavam;
    private String chassi;
    private String marca;
    private String modelo;
//    private br.ufjf.scLab.model.entity.AutomovelEstado estado;

    public static AutomovelAlugadoDTO create(AutomovelAlugado automovel) {
        ModelMapper modelMapper = new ModelMapper();
    }

}
