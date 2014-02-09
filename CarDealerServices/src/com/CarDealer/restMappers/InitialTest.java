package com.CarDealer.restMappers;


import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.CarDealer.dao.PersonDAO;
import com.CarDealer.dao.PersonDTO;


@Path("init")
public class InitialTest {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Jersey";
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String replyInfoText(@PathParam("param") String param){
		PersonDAO perDao = new PersonDAO();
		ArrayList<PersonDTO> persons = perDao.getPersonList();
		ObjectMapper jsonMapper = new ObjectMapper();
		String personsInJson = null;
		try {
			personsInJson = jsonMapper.writeValueAsString(persons);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personsInJson;
	}
	

}
