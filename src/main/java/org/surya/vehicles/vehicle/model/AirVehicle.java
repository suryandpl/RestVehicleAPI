package org.surya.vehicles.vehicle.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AirVehicle implements Vehicle{

	long vid;
	String vehicleName;
	String fuel;
	int enginecapacity;
	int speed;
	long weight;
	
	public AirVehicle(long id,String vname,String fuel,int cc,int speed, long weight) {
		this.vid=id;
		this.vehicleName=vname;
		this.fuel=fuel;
		this.enginecapacity=cc;
		this.speed=speed;
		this.weight=weight;
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
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
}
