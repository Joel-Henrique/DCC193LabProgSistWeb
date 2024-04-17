package br.ufjf.scLab.model.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Locacao {
    private LocalDateTime dataHoraLocacao;
    private LocalDateTime dataHoraDevolucao;
    private long kilometragemInicial;
    private long kilometragemFinal;

    private double CalculaLocacao;
    private long valorLocacao;
}
