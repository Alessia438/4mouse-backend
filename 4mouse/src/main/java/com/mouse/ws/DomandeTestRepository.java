package com.mouse.ws;

import java.util.List;
//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DomandeTestRepository extends JpaRepository <DomandeTest, DomandeTestSerialize> {
	
	@Query(value="SELECT * FROM rattabase.domande_test WHERE id_test=?1", nativeQuery=true)
	List<DomandeTest> findByIdTest(long id_test);

}
