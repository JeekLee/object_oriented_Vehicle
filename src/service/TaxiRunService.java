package service;

import domain.Taxi;
import domain.Vehicle;

public class TaxiRunService implements RunService{
    @Override
    public String passengerInfo(Vehicle vehicle) {
        if (vehicle.getPresentPassenger() > 0){
            return "LED Off";
        }
        return "빈 차";
    }

    public int fareCalc(Taxi taxi){
        int result = taxi.getBasicFare();
        // 택시 추가 요금이 버림인가 올림인가 모르겠음... 일단 버림으로 계산
        result = result + (taxi.getDistanceToDestination() - taxi.getBasicDistance()) * taxi.getDistanceFare();
        return result;
    }
    public void payment(Taxi taxi, int fare){
        taxi.setAccumulatedFare(taxi.getAccumulatedFare() + fare);
        taxi.setPresentPassenger(0);
    }
}
