package br.com.cadastrosfuncionarios.crud.repository;

import br.com.cadastrosfuncionarios.crud.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(value = "SELECT COUNT(*) FROM FUNCIONARIO ", nativeQuery = true)
    Long getCount();
}
