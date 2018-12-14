package org.surya.vehicles.vehicle.database;

import java.util.HashMap;
import java.util.Map;

import org.surya.vehicles.vehicle.model.AirVehicle;
import org.surya.vehicles.vehicle.model.RoadVehicle;
import org.surya.vehicles.vehicle.model.WaterVehicle;

public class VehicleDAO {

	//Road Transport
	private static Map<Long,RoadVehicle> carDao =  new HashMap<Long,RoadVehicle>();
	private static Map<Long,RoadVehicle> truckDao =  new HashMap<Long,RoadVehicle>();
	//Water Transport	
	private static Map<Long,WaterVehicle> boatDao =  new HashMap<Long,WaterVehicle>();
	private static Map<Long,WaterVehicle> vesselDao =  new HashMap<Long,WaterVehicle>();
	
	//Air Transport	
	private static Map<Long,AirVehicle> airBusDao =  new HashMap<Long,AirVehicle>();
	private static Map<Long,AirVehicle> droneDao =  new HashMap<Long,AirVehicle>();
	
	public static Map<Long,RoadVehicle> getCarsDao(){
		return carDao;
	}
	public static Map<Long,RoadVehicle> getTrucksDao(){
		return truckDao;
	}
	public static Map<Long,WaterVehicle> getBoatDao(){
		return boatDao;
	}
	public static Map<Long,WaterVehicle> getVesselDao(){
		return vesselDao;
	}
	public static Map<Long,AirVehicle> getAirBusDao(){
		return airBusDao;
	}
	public static Map<Long,AirVehicle> getDroneDao(){
		return droneDao;
	}
}
