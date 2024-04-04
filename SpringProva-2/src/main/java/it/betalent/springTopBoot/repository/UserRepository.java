package it.betalent.springTopBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.betalent.springTopBoot.entity.User;



@Repository
	public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
