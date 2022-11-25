package service;

import domain.Bus;
import domain.BusAgePolicy;
import domain.Vehicle;

public class BusRunService implements RunService{
    @Override
    public String passengerInfo(Vehicle vehicle) {
        double tmp = (double) vehicle.getPresentPassenger() / vehicle.getMaxPassenger();
        if (tmp > 0.8){
            return "혼잡";
        }
        if (tmp < 0.2){
            return "여유";
        }
        return "보통";
    }

    public int fareCalc(Bus bus, int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            BusAgePolicy busAgePolicy = BusAgePolicy.of(arr[i]);
            result = result + busAgePolicy.calculateFareAppliedAgePolicy(bus.getFare());
        }
        return result;
    }
}
