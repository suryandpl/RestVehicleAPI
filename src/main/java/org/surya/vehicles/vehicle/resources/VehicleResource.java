package org.surya.vehicles.vehicle.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("vehicle")
public class VehicleResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getVehicles(){
		return "Car,Bus..etc..";
	}
}
