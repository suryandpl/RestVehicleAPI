package org.surya.vehicles.vehicle.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoadVehicle  implements Vehicle{
	long vid;
	String vehicleName;
	String brandName;
	String fuel;
	int enginecapacity;
	int speed;
	//Default constructor
	public RoadVehicle() {
		
	}
	public RoadVehicle(long id,String vname,String bname,String fuel,int cc,int speed) {
		this.vid=id;
		this.vehicleName=vname;
		this.brandName=bname;
		this.fuel=fuel;
		this.enginecapacity=cc;
		this.speed=speed;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public long getVid() {
		return vid;
	}
	public void setVid(long vid) {
		this.vid = vid;
	}
	public int getEnginecapacity() {
		return enginecapacity;
	}
	public void setEnginecapacity(int enginecapacity) {
		this.enginecapacity = enginecapacity;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
