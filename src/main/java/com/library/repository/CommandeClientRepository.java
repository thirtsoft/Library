package com.library.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.entities.CommandeClient;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {
	
	@Query("select count(p) from CommandeClient p where p.dateCommande between :d1 and :d2")
	public Integer countBetween(@Param("d1")Date d1, @Param("d2")Date d2);
	
	@Query("select p from CommandeClient p where p.numCommande like :num")
	public CommandeClient findByNumCommande(@Param("num") String numCommande);
	
	@Query("select c from CommandeClient c where c.numCommande like :num") 
	public List<CommandeClient> ListCommandeClientByNumCommande(@Param("num") String numCommande);
	
	@Query("select p from CommandeClient p where p.status like :status")
	public CommandeClient findByStatus(@Param("status") String status);
	
	@Query("select c from CommandeClient c where c.status like :status") 
	public List<CommandeClient> ListCommandeClientByStatus(@Param("status") String status);

	public List<CommandeClient> findAllByDateCommande(Date dateCommande);

	@Query("select p from CommandeClient p where p.client.id =:id")
	public Page<CommandeClient> findCommandeClientByClientId(@Param("id") Long clientId, Pageable pageable);
	
	@Query("select p from CommandeClient p where p.client.id =:cl")
	public List<CommandeClient> ListCommandeClientByClientId(@Param("cl") Long clientId);
		
	@Query("select p from CommandeClient p")
	public Page<CommandeClient> findAllCommandeClientByPageable(Pageable pageable);
	  
	@Query("select p from CommandeClient p where p.numCommande like :mc")
	public Page<CommandeClient> findCommandeClientByKeyWord(@Param("mc") String mc, Pageable pageable);

	

}
