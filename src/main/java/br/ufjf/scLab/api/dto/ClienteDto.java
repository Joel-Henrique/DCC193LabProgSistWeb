package br.ufjf.scLab.api.dto;

import br.ufjf.scLab.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private int telefone;
    private String ruaEnd;
    private int numeroEnd;
    private int cep;
    private String email;
    private List<Long> idsLocacoes;

    public static ClienteDto create(Cliente cliente) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteDto dto = modelMapper.map(cliente, ClienteDto.class);
        return dto;
    }

}
