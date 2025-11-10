public class Car {
    static int carIdCounter = 1;
    Integer carId;
    CarType carType;
    Double amountPerRide;
    Character restPosition;
    Byte dropTime;

    public Car(CarType carType,Double amountPerRide) {
        this.carId=carIdCounter++;
        this.carType = carType;
        this.amountPerRide=amountPerRide;
        this.restPosition='A';
        this.dropTime=null;
    }

    public void setRestPosition(Character restPosition) {
        this.restPosition = restPosition;
    }

    public Integer getCarId() {
        return carId;
    }

    public CarType getCarType() {
        return carType;
    }

    public Double getAmountPerRide() {
        return amountPerRide;
    }

    public Character getRestPosition() {
        return restPosition;
    }

    public Byte getDropTime() {
        return dropTime;
    }
}
