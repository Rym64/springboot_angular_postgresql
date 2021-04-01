package tn.cni.injez.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.Decomposition;

@Repository
public interface DecompositionRepository extends JpaRepository<Decomposition, Integer>{
	//@Query(nativeQuery = true, value="with recursive cte as (select id, code,libelle,montant,montant_actualise,date_actualisation,date_debut,date_debut_actualise,date_fin,date_fin_actualise,type_decomposition,decomposition_mere,niveau_decomposition,degres_decomposition,projet_code,cast(lpad(id\\:\\:text, 22, '0') as bpchar) as path from public.decomposition where decomposition_mere is null union all select s.id, s.code,s.libelle,s.montant,s.montant_actualise,s.date_actualisation,s.date_debut,s.date_debut_actualise,s.date_fin,s.date_fin_actualise,s.type_decomposition,s.decomposition_mere,s.niveau_decomposition,s.degres_decomposition,s.projet_code, concat(cte.path, '->', lpad(s.id\\:\\:text, 22, '0')) from cte join public.decomposition s on s.decomposition_mere = cte.code) select * from cte order by path")
	
	@Query(nativeQuery = true, value="with recursive cte as (\r\n" + 
			"	select t.*, array[id] path from public.decomposition t where decomposition_mere is null\r\n" + 
			"	union all\r\n" + 
			"	select t.*, c.path || t.id\r\n" + 
			"	from cte c\r\n" + 
			"	inner join public.decomposition t on t.decomposition_mere = c.code\r\n" + 
			")\r\n" + 
			"select * from cte where projet_code = :myStr order by path")

	List<Decomposition> findAndOrder(@Param("myStr") String myStr);

}
