package br.com.cadastrosfuncionarios.crud.validacao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrosModel {

    private String campo;
    private String erro;


}
