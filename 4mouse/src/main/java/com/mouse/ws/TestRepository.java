package com.mouse.ws;

//import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long> {
	
	@Query(value="SELECT * FROM rattabase.test WHERE data=?1", nativeQuery=true)
	Optional<Test> findByData(String data);

}
