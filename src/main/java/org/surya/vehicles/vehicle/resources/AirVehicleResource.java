package org.surya.vehicles.vehicle.resources;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.surya.vehicles.vehicle.model.AirVehicle;
import org.surya.vehicles.vehicle.services.AirVehicleService;


@Path("airvehicle")
public class AirVehicleResource {


	@Autowired
	private AirVehicleService service;
	
	/*@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public String getVehicles(){
		return "AirBus,Drone,AirBalloon";
	}*/
	
	
	@GET @Path("/{vtype}") 
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<AirVehicle> getVehiclesByType(@PathParam("vtype") String vtype) {
		return service.getAllTypeVehicles(vtype);
	}
	
	/**
	 *Fetching list of vehicles based on vehicle type
	 *@param : vehicleType(AirBus,Drone)
	 *@param : vehicleId  
	 */
	@GET
	@Path("/{vehicleType}/{vehicleId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AirVehicle getAirVehicle(@PathParam("vehicleType") String vehicleType,@PathParam("vehicleId") long id){
		return service.getAirVehicle(vehicleType,id);
	}
	
	/**
	 *Adding an new air vehicle 
	 *@param : Vehicle
	 */
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AirVehicle addAirVehicle(AirVehicle vehicle){
		System.out.println("Vehicle : "+vehicle);
		return service.addAirVehicle(vehicle);
	}
	
	/**
	 *Updating an existing air based vehicle 
	 *@param : Vehicle
	 */
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public AirVehicle updateAirVehicle(AirVehicle vehicle){
		return service.updateAirVehicle(vehicle);
	}
	
	/**
	 *deleting an vehicle
	 *@param : vehicleType(airbus,drone)
	 *@param : vehicleId  
	 */
	@DELETE
	@Path("/{vehicleType}/{vehicleId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteAirVehicle(@PathParam("vehicleType") String vehicleType,@PathParam("vehicleId") long id){
		service.deleteAirVehicle(vehicleType,id);
	}


}
