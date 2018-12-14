package org.surya.vehicles.vehicle.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.surya.vehicles.vehicle.database.VehicleDAO;
import org.surya.vehicles.vehicle.model.RoadVehicle;

public class RoadVehicleService {


	Map<Long,RoadVehicle> RoadVehCarDao = VehicleDAO.getCarsDao();
	Map<Long,RoadVehicle> RoadVehTruckDao = VehicleDAO.getTrucksDao();
	
	/*public RoadVehicleService(){
		RoadVehCarDao.put(1L, new RoadVehicle(1,"BMW","Petrol",2000));
		RoadVehCarDao.put(2L, new RoadVehicle(2,"Audi","Diesel",1500));
	}*/
	
	//Fetching list of vehicles for particular type(Car,Truck,Bus..) type from DAO 
	public List<RoadVehicle> getAllTypeVehicles(String vtype){
		List<RoadVehicle> rList = new ArrayList<RoadVehicle>();
		if(null !=vtype) {
			if("car".equalsIgnoreCase(vtype)) {
				rList =  (ArrayList<RoadVehicle>) RoadVehCarDao.values();
			}else if("Truck".equalsIgnoreCase(vtype)) {
				rList =  (ArrayList<RoadVehicle>) RoadVehTruckDao.values();
			}
		} else {
			System.out.println("Vehicle type request is empty");
		}
		return rList;
	}
	//Fetching an specific vehicle type from DAO
	public RoadVehicle getRoadVehicle(String vtype,Long id){
		RoadVehicle rvehicle = null;
		if(null !=vtype) {
			if("car".equalsIgnoreCase(vtype)) {
				rvehicle =  RoadVehCarDao.get(id);
			}else if("Truck".equalsIgnoreCase(vtype)) {
				rvehicle =  RoadVehTruckDao.get(id);
			}
		} else {
			System.out.println("Vehicle type request is empty");
		}
		return rvehicle;
	}
	//Adding Vehicle into DAO
	public RoadVehicle addRoadVehicle(RoadVehicle vehicle){
		if(vehicle.getVehicleName()!=null) {
			if("Car".equalsIgnoreCase(vehicle.getVehicleName())) {
				vehicle.setVid(RoadVehCarDao.size()+1);
				RoadVehCarDao.put(vehicle.getVid(), vehicle);
			}else if("Truck".equalsIgnoreCase(vehicle.getVehicleName())) {
				vehicle.setVid(RoadVehTruckDao.size()+1);
				RoadVehTruckDao.put(vehicle.getVid(), vehicle);
			}
		}else {
			System.out.println("The vehicle is an empty for adding Road based vehicle");
		}
		return vehicle;
	}
	//Updating Vehicle into DAO
	public RoadVehicle updateRoadVehicle(RoadVehicle vehicle){
		if(vehicle.getVid()==0)return null;
		if(vehicle.getVehicleName()!=null) {
			if("Car".equalsIgnoreCase(vehicle.getVehicleName())) {
				RoadVehCarDao.put(vehicle.getVid(), vehicle);
			}else if("Truck".equalsIgnoreCase(vehicle.getVehicleName())) {
				RoadVehTruckDao.put(vehicle.getVid(), vehicle);
			}
		}else {
			System.out.println("The vehicle is an empty for updating Road based vehicle");
		}
		return vehicle;
	}
	//Deleting vehicle from DAO
	public RoadVehicle deleteRoadVehicle(String vtype,Long id){
		RoadVehicle rvehicle = null;
		if(null !=vtype) {
			if("car".equalsIgnoreCase(vtype)) {
				rvehicle =  RoadVehCarDao.remove(id);
			}else if("Truck".equalsIgnoreCase(vtype)) {
				rvehicle =  RoadVehTruckDao.remove(id);
			}
		} else {
			System.out.println("Vehicle type request is empty to delete raod based vehicle");
		}
		return rvehicle;
	}

}
