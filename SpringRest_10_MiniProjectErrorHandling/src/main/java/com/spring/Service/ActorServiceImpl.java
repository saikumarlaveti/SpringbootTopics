package com.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Exception.ActorNotFoundException;
import com.spring.Model.Actor;
import com.spring.Repository.ActorRepository;

@Service("actorMgmtService")
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	private ActorRepository service;
	@Override
	public String registerActor(Actor actor) {
		service.save(actor);
		return "Actor is saved : " + actor.getActorId();
	}
	/*
	@Override
	public Iterable<Actor> getAll() {
		Iterable<Actor> it = service.findAll();
		List<Actor> list = (List<Actor>) it;
		list.sort((t1,t2)->t1.getActorName().compareTo(t2.getActorName()));
		return list;
	}
	*/

	public Iterable<Actor> getAll() {
		Iterable<Actor> list = service.findAll();
		return list;
	}

	@Override
	public Actor getById(Integer id) {
		return service.findById(id).orElseThrow(()->new IllegalArgumentException("Actor Not Found"));
	}

	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> opt = service.findById(actor.getActorId());
		if(opt.isPresent()) {
			service.save(actor);
			return "Actor is updated";
		}
		else {
			throw new ActorNotFoundException("Actor Not Found");
		}

	}

	@Override
	public List<Actor> fetchBycategory(String category1, String category2) {
		List<Actor> list = service.fetchBycategory(category1, category2);
		return list;
	}

	@Override
	public String deleteById(Integer id) {
		Optional<Actor> actor = service.findById(id);
		if(actor.isPresent()) {
			service.deleteById(id);
			return "Actor removed successfully from movies";
		}
		return "Actor not Acted in this movie";
	}
	@Override
	public String updateActorMoblie(Integer id, long newmoblieNo) {
		
		Optional<Actor> actor = service.findById(id);
		if(actor.isPresent()) {
			Actor act = actor.get();
			act.setMoblieNo(newmoblieNo);
			service.save(act);
			return "Actor Mobile number updated";
		}
		else {
		 throw new ActorNotFoundException("Actor not found");
	}
	
	}

}
