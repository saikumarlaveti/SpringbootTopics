package com.spring.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.spring.Model.Actor;

public interface ActorRepository extends CrudRepository<Actor,Integer>{
	
	@Query("from Actor where category in(:c1,:c2)order by category")
	public List<Actor> fetchBycategory(@Param("c1") String category1,@Param("c2") String category2);

}
