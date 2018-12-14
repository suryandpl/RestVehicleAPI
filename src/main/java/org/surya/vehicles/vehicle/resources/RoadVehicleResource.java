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

import org.surya.vehicles.vehicle.model.RoadVehicle;
import org.surya.vehicles.vehicle.services.RoadVehicleService;

@Path("roadvehicle")
public class RoadVehicleResource {


	RoadVehicleService service = new RoadVehicleService();
	
	/*@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public String getVehicles(){
		return "Car,Bus..etc..";
	}*/
	
	
	@GET @Path("/{vtype}") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoadVehicle> getVehiclesByType(@PathParam("vtype") String vtype) {
		return service.getAllTypeVehicles(vtype);
	}
	
	/**
	 *Fetching list of vehicles based on vehicle type
	 *@param : vehicleType(car,truck)
	 *@param : vehicleId  
	 */
	@GET
	@Path("/{vehicleType}/{vehicleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public RoadVehicle getRoadVehicle(@PathParam("vehicleType") String vehicleType,@PathParam("vehicleId") long id){
		return service.getRoadVehicle(vehicleType,id);
	}
	
	/**
	 *Adding an new road vehicle 
	 *@param : Vehicle
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public RoadVehicle addRoadVehicle(RoadVehicle vehicle){
		System.out.println("Vehicle : "+vehicle);
		return service.addRoadVehicle(vehicle);
	}
	
	/**
	 *Updating an existing Road based vehicle 
	 *@param : Vehicle
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RoadVehicle updateRoadVehicle(RoadVehicle vehicle){
		return service.updateRoadVehicle(vehicle);
	}
	
	/**
	 *deleting an vehicle
	 *@param : vehicleType(car,truck)
	 *@param : vehicleId  
	 */
	@DELETE
	@Path("/{vehicleType}/{vehicleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteRoadVehicle(@PathParam("vehicleType") String vehicleType,@PathParam("vehicleId") long id){
		service.deleteRoadVehicle(vehicleType,id);
	}

}
