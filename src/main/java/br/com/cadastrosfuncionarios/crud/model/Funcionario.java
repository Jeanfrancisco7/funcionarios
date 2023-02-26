package br.com.cadastrosfuncionarios.crud.model;

import br.com.cadastrosfuncionarios.crud.validacao.ValidException;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 30)
    private String nome;

    @NotEmpty
    @NotNull
    @Length(min = 2, max = 50)
    private String sobrenome;

    @Email(message = "Email não é válido")
    @NotEmpty(message = "Email está vazio")
    private String email;

    private String nis;

    public void setNis(String nis) {
        if (nis.matches("\\d+")) {
            this.nis = nis;
        }else{
            throw new ValidException("O campo NIS aceita apenas numeros!");
        }
    }
}
