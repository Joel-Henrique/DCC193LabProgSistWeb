package br.ufjf.scLab.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraLocacao;
    private LocalDateTime dataHoraDevolucao;
    private long kilometragemInicial;
    private long kilometragemFinal;

    private double CalculaLocacao;
    private long valorLocacao;

    @OneToOne // tt
    private Automovel automovel;
}
