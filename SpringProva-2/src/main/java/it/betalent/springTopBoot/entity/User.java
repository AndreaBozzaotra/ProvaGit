package it.betalent.springTopBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
	private Integer id_user;
	private String username;
	private String password;
public User() {
	
}
public Integer getId_user() {
	return id_user;
}
public void setId_user(Integer id_user) {
	this.id_user = id_user;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
@Override
public String toString() {
	return "User [id_user=" + id_user + ", username=" + username + ", password=" + password + "]";
}

}
