package it.betalent.springTopBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.betalent.springTopBoot.entity.Attore;
import it.betalent.springTopBoot.entity.User;
import it.betalent.springTopBoot.repository.ATRepository;


@Service
public class ATService {
 
    @Autowired
    private ATRepository repo;
     public User login() {
    	 User user = new User();
    			 return user;
     }
    
    public List<Attore> listAll() {
        List<Attore> lista = repo.findAll();
        return lista;
    }
     
    public void save(Attore product) {
        repo.save(product);
    }
     
    public Attore get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
    public List<Attore> findByNome(String Nome) {
    	return repo.findByNome(Nome);
    }
}

