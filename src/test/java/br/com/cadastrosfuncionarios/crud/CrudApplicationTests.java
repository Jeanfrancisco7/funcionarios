package br.com.cadastrosfuncionarios.crud;

import br.com.cadastrosfuncionarios.crud.model.Funcionario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Valid;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTests {

	@Test
	public void cadastraFuncionarioNisComLetras() {
		Funcionario funcionario = new Funcionario();
		try{
			funcionario.setNome("Jeanfrancisco");
			funcionario.setSobrenome("PolloStrapasson");
			funcionario.setEmail("Jean@teste.com");
			funcionario.setNis("123456asd");
			Assert.fail("Não gerou erro");
		}catch (Exception e ){
			Assert.assertEquals("O campo NIS aceita apenas numeros!", e.getMessage());
		}
	}

}
