public class VehicleFactory{
    public static Vehicle getVehicle(String s){

        if(s == "Car")
            return new Car();
        if(s == "Truck")
            return new Truck();
        if(s == "Bike")
            return new Bike();
        return null;
    }
}