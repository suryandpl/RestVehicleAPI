package org.surya.vehicles.vehicle.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.surya.vehicles.vehicle.database.VehicleDAO;
import org.surya.vehicles.vehicle.model.AirVehicle;



public class AirVehicleService {

	Map<Long,AirVehicle> airVehAeroDao = VehicleDAO.getAirBusDao();
	Map<Long,AirVehicle> airVehDroneDao = VehicleDAO.getDroneDao();
	
	public AirVehicleService(){
		airVehAeroDao.put(1L, new AirVehicle(1,"AIRBUS","SpiceJet","Petrol",100000,5000,50000L));
		airVehDroneDao.put(2L, new AirVehicle(1,"Drone","Blade","Battery",50,35,10L));
	}
	
	//Fetching list of vehicles for particular type(airbus,drone,..) type from DAO 
	public List<AirVehicle> getAllTypeVehicles(String vtype){
		List<AirVehicle> aList = new ArrayList<AirVehicle>();
		if(null !=vtype) {	
			if("airbus".equalsIgnoreCase(vtype)) {
				aList =  new ArrayList<AirVehicle>(airVehAeroDao.values());
			}else if("drone".equalsIgnoreCase(vtype)) {
				aList =  new ArrayList<AirVehicle>(airVehDroneDao.values());
			}
		} else {
			System.out.println("Air Vehicle type request is empty");
		}
		return aList;
	}
	//Fetching an specific vehicle type from DAO
	public AirVehicle getAirVehicle(String vtype,Long id){
		AirVehicle avehicle = null;
		if(null !=vtype) {
			if("airbus".equalsIgnoreCase(vtype)) {
				avehicle =  airVehAeroDao.get(id);
			}else if("drone".equalsIgnoreCase(vtype)) {
				avehicle =  airVehDroneDao.get(id);
			}
		} else {
			System.out.println("Vehicle type request is empty");
		}
		return avehicle;
	}
	//Adding air Vehicle into DAO
	public AirVehicle addAirVehicle(AirVehicle vehicle){
		if(vehicle.getVehicleName()!=null) {
			if("airbus".equalsIgnoreCase(vehicle.getVehicleName())) {
				vehicle.setVid(airVehAeroDao.size()+1);
				airVehAeroDao.put(vehicle.getVid(), vehicle);
			}else if("drone".equalsIgnoreCase(vehicle.getVehicleName())) {
				vehicle.setVid(airVehDroneDao.size()+1);
				airVehDroneDao.put(vehicle.getVid(), vehicle);
			}
		}else {
			System.out.println("The vehicle is an empty for adding Air based vehicle");
		}
		return vehicle;
	}
	//Updating air Vehicle into DAO
	public AirVehicle updateAirVehicle(AirVehicle vehicle){
		if(vehicle.getVid()==0)return null;
		if(vehicle.getVehicleName()!=null) {
			if("airbus".equalsIgnoreCase(vehicle.getVehicleName())) {
				airVehAeroDao.put(vehicle.getVid(), vehicle);
			}else if("drone".equalsIgnoreCase(vehicle.getVehicleName())) {
				airVehDroneDao.put(vehicle.getVid(), vehicle);
			}
		}else {
			System.out.println("The vehicle is an empty for updating Air based vehicle");
		}
		return vehicle;
	}
	//Deleting air vehicle from DAO
	public AirVehicle deleteAirVehicle(String vtype,Long id){
		AirVehicle avehicle = null;
		if(null !=vtype) {
			if("airbus".equalsIgnoreCase(vtype)) {
				avehicle =  airVehAeroDao.remove(id);
			}else if("drone".equalsIgnoreCase(vtype)) {
				avehicle =  airVehDroneDao.remove(id);
			}
		} else {
			System.out.println("Vehicle type request is empty to delete air based vehicle");
		}
		return avehicle;
	}

}
