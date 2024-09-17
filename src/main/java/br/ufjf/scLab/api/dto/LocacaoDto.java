package br.ufjf.scLab.api.dto;

import br.ufjf.scLab.model.entity.Locacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocacaoDto {

    private Long id;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private long quilometragemInicial;
    private long quilometragemFinal;
    private double valorLocacao;
    private String placaAutomovel;
    private Long idCliente;
    private boolean finalizada;

    public static Object create(Locacao locacao) {
        ModelMapper modelMapper = new ModelMapper();
        LocacaoDto dto = modelMapper.map(locacao, LocacaoDto.class);
        return dto;
    }
}
