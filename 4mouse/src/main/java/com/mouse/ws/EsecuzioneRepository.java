package com.mouse.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EsecuzioneRepository extends JpaRepository <Esecuzione, EsecuzioneSerialize>{

	@Query(value="SELECT * FROM rattabase.esecuzione WHERE email =?1 AND id_test = ?2 AND id_domanda = ?3", nativeQuery=true)

	Optional<Esecuzione> findEsecuzione(String email, long id_test, long id_domanda);
}

