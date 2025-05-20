package com.spring.Service;

import java.util.List;
import java.util.Optional;

import com.spring.Model.Actor;

public interface ActorService {
	
	public String registerActor(Actor actor);
	
	public Iterable<Actor> getAll();
	
	public Actor getById(Integer id);
	
	public String updateActor(Actor actor);
	
	public List<Actor> fetchBycategory(String category1,String category2);
	
	public String deleteById(Integer id);
	
	public String updateActorMoblie(Integer id,long newmoblieNo);

}
