package br.com.cadastrosfuncionarios.crud;

import br.com.cadastrosfuncionarios.crud.model.Funcionario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudApplicationTests {

	@Test
	void cadastraFuncionarioComMenosDeDoisCaracteres() {
		Funcionario funcionario = new Funcionario();
		try{
			funcionario.setNome("J");
			funcionario.setSobrenome("PolloStrapasson");
			funcionario.setEmail("Jean@teste.com");
			funcionario.setNis("123456");
			Assert.fail("Não gerou erro");
		}catch (Exception e ){
			Assert.assertEquals("Funcionario não pode ter menos que 2 caracteres", e.getMessage());
		}
	}

	@Test
	void cadastraFuncionarioComMaisDeCinquentaCaracteres() {
		Funcionario funcionario = new Funcionario();
		try{
			funcionario.setNome("JeanfranciscoJeanfranciscoJeanfranciscoJeanfranciscoJeanfrancisco");
			funcionario.setSobrenome("PolloStrapasson");
			funcionario.setEmail("Jean@teste.com");
			funcionario.setNis("123456");
			Assert.fail("Não gerou erro");
		}catch (Exception e ){
			Assert.assertEquals("Funcionario não pode ter mais que 50 caracteres", e.getMessage());
		}
	}

	@Test
	void cadastraFuncionarioEmailErrado() {
		Funcionario funcionario = new Funcionario();
		try{
			funcionario.setNome("Jeanfrancisco");
			funcionario.setSobrenome("PolloStrapasson");
			funcionario.setEmail("Jean");
			funcionario.setNis("123456");
			Assert.fail("Não gerou erro");
		}catch (Exception e ){
			Assert.assertEquals("Funcionario não pode ter mais que 50 caracteres", e.getMessage());
		}
	}

	@Test
	void cadastraFuncionarioNisComLetras() {
		Funcionario funcionario = new Funcionario();
		try{
			funcionario.setNome("Jeanfrancisco");
			funcionario.setSobrenome("PolloStrapasson");
			funcionario.setEmail("Jean@teste.com");
			funcionario.setNis("123456asd");
			Assert.fail("Não gerou erro");
		}catch (Exception e ){
			Assert.assertEquals("Funcionario não pode ter mais que 50 caracteres", e.getMessage());
		}
	}

}
