package com.spring.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.Model.Actor;

@Controller
public class ActorController {
	
	@Autowired
	public RestTemplate template;
	
	@Autowired
	public Environment env;
	

	@GetMapping("/")
	public String Home() {
		return "HomePage";
	}
	
	@GetMapping("/actor_report")
	public String fetchAllActor(Map<String,Object> map) throws JsonMappingException, JsonProcessingException {
		//String serviceUrl = "http://localhost:8080/SpringRest_16_ProducerApp-Actor/api/details";
		String serviceUrl = env.getProperty("fetchAllActor.serviceUrl"); //from property file
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		
		String jsonBody = response.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Actor> list = mapper.readValue(jsonBody, new TypeReference<List<Actor>> (){});
		
		map.put("actorInfo", list);
		
		return "show_report";
	}
	
	@GetMapping("/actor_add")
	public String addActor(@ModelAttribute("actor") Actor actor) {
		return "register_actor";
	}
	
	@PostMapping("/actor_add")
	public String registerActor(@ModelAttribute("actor") Actor actor,
			RedirectAttributes attrs) throws Exception {
		
		ObjectMapper mapper =  new ObjectMapper();
		String jsonContent=mapper.writeValueAsString(actor);
		System.out.println("registerActor :" +jsonContent );
		
		String serviceUrl = env.getRequiredProperty("registerActor.serviceUrl");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity= new HttpEntity<String>(jsonContent,headers);
		
		ResponseEntity<String> response = template.exchange(serviceUrl,HttpMethod.POST,entity,String.class);
		
		String msg = response.getBody();
		attrs.addFlashAttribute("resultMsg",msg);
		
		return "redirect:actor_report";			
}
	
	@GetMapping("/actor_delete")
	public String deleteActor(@RequestParam("aid") Integer id,
			RedirectAttributes attrs)throws Exception
			 {
		
		String serviceUrl=env.getRequiredProperty("actor.delete");
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.DELETE, 
				null, 
				String.class,
				Map.of("id",id));
		String msg = response.getBody();
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:actor_report";		
	}
	
	@GetMapping("/actor_edit")
	public String updateFormPage(@RequestParam("aid") int id,
			@ModelAttribute("artist") Actor actor) throws Exception
	{
	
		String serviceUrl = env.getRequiredProperty("actor.update1");
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class, Map.of("id",id));
		
		ObjectMapper mapper = new ObjectMapper();
		Actor actor1 = mapper.readValue(response.getBody(),Actor.class);
		BeanUtils.copyProperties(actor1, actor);
		
		return "update_actor";
		
	}
	
	@PostMapping("/actor_edit")
	public String updateActor(@ModelAttribute("actor") Actor actor,
			RedirectAttributes attrs) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent=mapper.writeValueAsString(actor);
		
		String serviceUrl = env.getRequiredProperty("actor.update2");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonContent,headers);
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.PUT, entity, String.class);
		
		String msg = response.getBody();
		attrs.addFlashAttribute("resultMsg",msg);
		
		return "redirect:actor_report";
		
	}
	
	
	
}
