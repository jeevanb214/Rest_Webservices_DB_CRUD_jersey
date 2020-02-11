package com.jeevan.restdb.RestWebServiceDB;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jeevan.model.Aliens;

@Path("aliens")
public class AliensResource {
	
	AlienRepository repo=new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)   //at present  we are version conflicts.{MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}
	public List<Aliens> getAliens() {	
		System.out.println("In  getAliens::");
		return repo.getAliens();	
	}
	
	@POST
	@Path("create")
	public Aliens createAlien(Aliens alien) {
		System.out.println("In aliens Reosorce::"+alien);
			repo.createAlien(alien);
			return alien;
	}
	
	
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON )   //at present  we are version conflicts.{MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}
	public Aliens getAlienById(@PathParam("id")int id)
	{
		System.out.println("getAlienById::"+id);
		return repo.getAlienById(id);
	}
	
	
	@PUT
	@Path("update")
	public Aliens updateAlien(Aliens alien) {
		System.out.println("In updateAlien Reosorce::"+alien);
			repo.updateAlien(alien);
			return alien;
	}
	
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON )   //at present  we are version conflicts.{MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}
	public void deleteAlienById(@PathParam("id")int id)
	{
		System.out.println("getAlienById::"+id);
		 repo.deleteAlienById(id);
	}
	

}
