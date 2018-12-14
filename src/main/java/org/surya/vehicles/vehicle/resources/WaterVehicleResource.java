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

import org.surya.vehicles.vehicle.model.WaterVehicle;
import org.surya.vehicles.vehicle.services.WaterVehicleService;

@Path("watervehicle")
public class WaterVehicleResource {


	WaterVehicleService service = new WaterVehicleService();
	
	/*@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public String getVehicles(){
		return "Boat,Vessel..";
	}*/
	
	
	@GET @Path("/{vtype}") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<WaterVehicle> getVehiclesByType(@PathParam("vtype") String vtype) {
		return service.getAllTypeVehicles(vtype);
	}
	
	/**
	 *Fetching list of vehicles based on vehicle type
	 *@param : vehicleType(boat,vessel)
	 *@param : vehicleId  
	 */
	@GET
	@Path("/{vehicleType}/{vehicleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public WaterVehicle getWaterVehicle(@PathParam("vehicleType") String vehicleType,@PathParam("vehicleId") long id){
		return service.getWaterVehicle(vehicleType,id);
	}
	
	/**
	 *Adding an new water vehicle 
	 *@param : Vehicle
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public WaterVehicle addWaterVehicle(WaterVehicle vehicle){
		System.out.println("Vehicle : "+vehicle);
		return service.addWaterVehicle(vehicle);
	}
	
	/**
	 *Updating an existing Water based vehicle 
	 *@param : Vehicle
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public WaterVehicle updateWaterVehicle(WaterVehicle vehicle){
		return service.updateWaterVehicle(vehicle);
	}
	
	/**
	 *deleting an vehicle
	 *@param : vehicleType(boat,vessel)
	 *@param : vehicleId  
	 */
	@DELETE
	@Path("/{vehicleType}/{vehicleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteWaterVehicle(@PathParam("vehicleType") String vehicleType,@PathParam("vehicleId") long id){
		service.deleteWaterVehicle(vehicleType,id);
	}

}
