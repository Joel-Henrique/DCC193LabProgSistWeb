package br.ufjf.scLab.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AutomovelEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public abstract String getEstado();
    public boolean DisponibilizarAutomovel(Automovel automovel){
        return false;
    }
    public boolean AlugarAutomovel(Automovel automovel){
        return false;
    }
    public boolean MandarAutomovelManutencao(Automovel automovel){
        return false;
    }

}
