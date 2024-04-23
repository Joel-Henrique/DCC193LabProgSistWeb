package br.ufjf.ldvapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Locacao {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime dataHoraLocacao;
    private LocalDateTime dataHoraDevolucao;
    private long kilometragemInicial;
    private long kilometragemFinal;

    private double CalculaLocacao;
    private double valorLocacao;
}
