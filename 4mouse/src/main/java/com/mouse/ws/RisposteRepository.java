package com.mouse.ws;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RisposteRepository extends JpaRepository<Risposte, Long> {
	
	@Query(value="SELECT * FROM rattabase.risposte WHERE id_domanda =?1", nativeQuery=true)

	List<Risposte> findById(long IdDomanda);

}
