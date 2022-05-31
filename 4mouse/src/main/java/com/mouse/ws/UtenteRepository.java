package com.mouse.ws;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtenteRepository extends JpaRepository<Utente, String> {
	List<Utente> findByemailContaining(String email);
	List<Utente> findByTipo(int tipo);
	
	@Query(value="SELECT * FROM rattabase.utente WHERE email =?1 AND password = ?2", nativeQuery=true)
	
    Utente findByEmailPwd(String email, String password); 
}