package org.surya.vehicles.vehicle.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.surya.vehicles.vehicle.database.VehicleDAO;
import org.surya.vehicles.vehicle.model.WaterVehicle;


public class WaterVehicleService {



	Map<Long,WaterVehicle> waterVehBoatDao = VehicleDAO.getBoatDao();
	Map<Long,WaterVehicle> waterVehVesselDao = VehicleDAO.getVesselDao();
	
	/*public WaterVehicleService(){
		waterVehBoatDao.put(1L, new WaterVehicle(1,"Boat","Diesel",20000,50,1000L,500L));
		waterVehBoatDao.put(2L, new WaterVehicle(2,"Vessel","Gas",1500000,40,500000l,10000L));
	}*/
	
	//Fetching list of vehicles for particular type(Boat,vessel,..) type from DAO 
	public List<WaterVehicle> getAllTypeVehicles(String vtype){
		List<WaterVehicle> rList = new ArrayList<WaterVehicle>();
		if(null !=vtype) {
			if("boat".equalsIgnoreCase(vtype)) {
				rList =  (ArrayList<WaterVehicle>) waterVehBoatDao.values();
			}else if("vessel".equalsIgnoreCase(vtype)) {
				rList =  (ArrayList<WaterVehicle>) waterVehVesselDao.values();
			}
		} else {
			System.out.println("Water Vehicle type request is empty");
		}
		return rList;
	}
	//Fetching an specific vehicle type from DAO
	public WaterVehicle getWaterVehicle(String vtype,Long id){
		WaterVehicle rvehicle = null;
		if(null !=vtype) {
			if("boat".equalsIgnoreCase(vtype)) {
				rvehicle =  waterVehBoatDao.get(id);
			}else if("vessel".equalsIgnoreCase(vtype)) {
				rvehicle =  waterVehVesselDao.get(id);
			}
		} else {
			System.out.println("Vehicle type request is empty");
		}
		return rvehicle;
	}
	//Adding Vehicle into DAO
	public WaterVehicle addWaterVehicle(WaterVehicle vehicle){
		if(vehicle.getVehicleName()!=null) {
			if("boat".equalsIgnoreCase(vehicle.getVehicleName())) {
				vehicle.setVid(waterVehBoatDao.size()+1);
				waterVehBoatDao.put(vehicle.getVid(), vehicle);
			}else if("vessel".equalsIgnoreCase(vehicle.getVehicleName())) {
				vehicle.setVid(waterVehVesselDao.size()+1);
				waterVehVesselDao.put(vehicle.getVid(), vehicle);
			}
		}else {
			System.out.println("The vehicle is an empty for adding Road based vehicle");
		}
		return vehicle;
	}
	//Updating Vehicle into DAO
	public WaterVehicle updateWaterVehicle(WaterVehicle vehicle){
		if(vehicle.getVid()==0)return null;
		if(vehicle.getVehicleName()!=null) {
			if("boat".equalsIgnoreCase(vehicle.getVehicleName())) {
				waterVehBoatDao.put(vehicle.getVid(), vehicle);
			}else if("vessel".equalsIgnoreCase(vehicle.getVehicleName())) {
				waterVehVesselDao.put(vehicle.getVid(), vehicle);
			}
		}else {
			System.out.println("The vehicle is an empty for updating Road based vehicle");
		}
		return vehicle;
	}
	//Deleting vehicle from DAO
	public WaterVehicle deleteWaterVehicle(String vtype,Long id){
		WaterVehicle rvehicle = null;
		if(null !=vtype) {
			if("boat".equalsIgnoreCase(vtype)) {
				rvehicle =  waterVehBoatDao.remove(id);
			}else if("vessel".equalsIgnoreCase(vtype)) {
				rvehicle =  waterVehVesselDao.remove(id);
			}
		} else {
			System.out.println("Vehicle type request is empty to delete raod based vehicle");
		}
		return rvehicle;
	}


}
