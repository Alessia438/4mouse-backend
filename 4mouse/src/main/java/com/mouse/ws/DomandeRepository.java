package com.mouse.ws;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DomandeRepository extends JpaRepository<Domande, Long>{
	
	List<Domande> findByModalita(int modalita);
	
	@Query(value="SELECT * FROM rattabase.domande WHERE id_domanda=?1", nativeQuery=true)
	List<Domande> findById(long id_domanda);

}
