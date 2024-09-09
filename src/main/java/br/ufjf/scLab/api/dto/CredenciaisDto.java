package br.ufjf.scLab.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciaisDto {
    private String login;
    private String senha;
}
