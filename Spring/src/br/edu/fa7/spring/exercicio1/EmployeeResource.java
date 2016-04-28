package br.edu.fa7.spring.exercicio1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.stereotype.Service;

import br.edu.fa7.ejb.EmployeService;

import com.sun.research.ws.wadl.Response;




@Path("/employee")
public class EmployeeResource {
	
	
	EmployeService service;
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id){
		
		
		Employe e = service.find(id);
		
		return null;
		
	}
	

}
