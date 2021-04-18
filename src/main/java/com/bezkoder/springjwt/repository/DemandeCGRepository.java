package com.bezkoder.springjwt.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.DemandeCG;








public interface DemandeCGRepository extends JpaRepository<DemandeCG, Long>{
	 List<DemandeCG> findByfirstname(String firstname );

	  List<DemandeCG> findByaddressContaining(String address);
}


