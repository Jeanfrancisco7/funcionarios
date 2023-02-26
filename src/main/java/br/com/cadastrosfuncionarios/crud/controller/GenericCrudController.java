package br.com.cadastrosfuncionarios.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class GenericCrudController<T, Repository extends JpaRepository, ID extends Serializable > {

    @Autowired
    protected Repository repository;

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id){
        return new ResponseEntity(repository.findById(id), HttpStatus.OK);
    };

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<T> update(@PathVariable ID id, @Valid @RequestBody T objeto){
        Optional<T> op = (Optional<T>) repository.findById(id);
        if (op.isPresent()) {
            return this.save(objeto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody T objeto){
        return new ResponseEntity((T)repository.save(objeto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<T> delete(@PathVariable ID id){
        Optional<T> op = (Optional<T>) repository.findById(id);
        if (op.isPresent()) {
            repository.delete(op.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll(){
        return ResponseEntity.ok((List<T>) repository.findAll());
    };


}
