package service;

import domain.Vehicle;

public interface RunService {
    default void runStart(Vehicle vehicle){
        vehicle.setStatus(true);
    }
    default void changeSpeed(Vehicle vehicle, int speed){
        if(vehicle.getFuel() < 10){
            System.out.println("주유 필요");
            return;
        }
        if(speed < 0){
            speed = 0;
        }
        vehicle.setSpeed(speed);
    }
    default void changeStatus(Vehicle vehicle, boolean status){
        if(status){
            vehicle.setStatus(status);
            return;
        }
        vehicle.setStatus(status);
        vehicle.setPresentPassenger(0);
    }
    default void passengerRide(Vehicle vehicle, int num){
        if (vehicle.getPresentPassenger() + num > vehicle.getMaxPassenger()){
            System.out.println("최대 승객 수를 초과하여 탑승할 수 없습니다.");
            return;
        }
        vehicle.setPresentPassenger(vehicle.getPresentPassenger()+num);
    }
    default void changeFuel(Vehicle vehicle, int num){
        int tmp = vehicle.getFuel() + num;
        if (tmp < 0){
            tmp = 0;
        }
        vehicle.setFuel(tmp);
        if (tmp < 10){
            vehicle.setStatus(false);       // 연료가 없으면 상태 변경(운행 종료)
            System.out.println("주유 필요");
        }
    }
    String passengerInfo(Vehicle vehicle);
}
