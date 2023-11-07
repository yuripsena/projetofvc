package com.projetopi.services;

import com.projetopi.entidades.Veiculo;
import com.projetopi.entidades.VeiculoNotFoundException;
import com.projetopi.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    public List<Veiculo> listAll() {
        var list = (List<Veiculo>) repo.findAll();
        System.out.println(list.size());
        return list;
    }

    public void save(Veiculo veiculo) {
        repo.save(veiculo);
    }

    public Veiculo get(Integer id) throws VeiculoNotFoundException {
        Optional<Veiculo> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new VeiculoNotFoundException("não foi possível encontrar nenhum veiculo com Id" +id);
    }

    public void delete(Integer id) throws VeiculoNotFoundException {
        Long count = repo.countById(id);
        if (count ==null || count == 0) {
            throw new VeiculoNotFoundException("não foi possível encontrar nenhum veiculo com Id" +id);

        }
        repo.deleteById(id);
    }

    public List<Veiculo> searchByNumero(String numero) {
        return repo.findByNumeroContaining(numero);
    }

}