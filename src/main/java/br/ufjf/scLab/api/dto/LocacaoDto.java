package br.ufjf.scLab.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long idAutomovel;
    private Long idCliente;
}
