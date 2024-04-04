package it.betalent.springTopBoot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.betalent.springTopBoot.entity.Attore;




@Repository
public interface ATRepository extends JpaRepository<Attore, Integer>{
	List<Attore> findByNome(String Nome);
}
