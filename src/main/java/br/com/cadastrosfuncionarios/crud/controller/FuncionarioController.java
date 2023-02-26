package br.com.cadastrosfuncionarios.crud.controller;

import br.com.cadastrosfuncionarios.crud.model.Funcionario;
import br.com.cadastrosfuncionarios.crud.repository.FuncionarioRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/funcionario")
@CrossOrigin(origins = "*")
public class FuncionarioController extends GenericCrudController<Funcionario, FuncionarioRepository, Long> {

    @GetMapping("/count")
    public ResponseEntity<Long> getCount(){
        return new ResponseEntity(repository.getCount(), HttpStatus.OK);
    }
}
