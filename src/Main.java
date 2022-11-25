import domain.Bus;
import domain.Taxi;
import service.BusRunService;
import service.TaxiRunService;

public class Main {
    public static int vehicle_num = 1000;
    public static Bus getBusInstance(){
        vehicle_num = vehicle_num + 1;
        return new Bus(vehicle_num);
    }
    public static Taxi getTaxiInstance(){
        vehicle_num = vehicle_num + 1;
        return new Taxi(vehicle_num);
    }
    public  static void test_bus(){
        System.out.println("-----------Bus Test-----------");
        // 버스 서비스 객체 생성
        BusRunService busRunService = new BusRunService();

        // 버스 2대 생성
        Bus bus1 = getBusInstance();
        Bus bus2 = getBusInstance();

        // 각 번호가 다른지 확인
        System.out.println("bus1 / bus2 : " + bus1.getNumber() + " / " + bus2.getNumber());

        // bus1로 진행
        // 1. 승객 +2
        int[] bus_passenger1 = {10, 30};
        busRunService.passengerRide(bus1, bus_passenger1.length);
        // 출력
        System.out.println("탑승 승객 수: " + bus1.getPresentPassenger());
        System.out.println("잔여 승객 수: " + (bus1.getMaxPassenger() - bus1.getPresentPassenger()));
        System.out.println("(승객의 나이에 따라 요금을 변경하는 기능 추가 구현)");
        System.out.println("요금 확인 : " + busRunService.fareCalc(bus1, bus_passenger1));
        System.out.println("(버스에 사람이 많은지 확인하는 기능 추가 구현)");
        System.out.println("버스 상태 : " + busRunService.passengerInfo(bus1));
        // 2. 주유량 -50 // 출력
        busRunService.changeFuel(bus1, -50);
        // 3. 상태 변경 -> 운행 종료
        busRunService.changeStatus(bus1, false);
        // 4. 주유 + 10
        busRunService.changeFuel(bus1, 10);
        // 출력
        if (!bus1.getStatus()){
            System.out.println("운행 종료");
        }
        else{
            System.out.println("운행 중");
        }
        System.out.println("잔여 주유량: " + bus1.getFuel());
        // 5. 상태 변경 -> 운행 중
        busRunService.changeStatus(bus1, true);
        // 6. 승객 45명 탑승
        busRunService.passengerRide(bus1, 45);
        // 7. 승객 5명 탑승
        int[] bus_passenger2 = {10, 30, 60, 70, 50};
        busRunService.passengerRide(bus1, bus_passenger2.length);
        // 출력
        System.out.println("탑승 승객 수: " + bus1.getPresentPassenger());
        System.out.println("잔여 승객 수: " + (bus1.getMaxPassenger() - bus1.getPresentPassenger()));
        System.out.println("(승객의 나이에 따라 요금을 변경하는 기능 추가 구현)");
        System.out.println("요금 확인 : " + busRunService.fareCalc(bus1, bus_passenger2));
        System.out.println("(버스에 사람이 많은지 확인하는 기능 추가 구현)");
        System.out.println("버스 상태 : " + busRunService.passengerInfo(bus1));
        // 8. 주유 -55
        busRunService.changeFuel(bus1,-55);
        System.out.println("잔여 주유량: " + bus1.getFuel());
        if (!bus1.getStatus()){
            System.out.println("운행 종료");
        }
        else{
            System.out.println("운행 중");
        }
    }
    public static void test_taxi(){
        System.out.println("-----------Taxi Test-----------");
        TaxiRunService taxiRunService = new TaxiRunService();
        // 택시 2대 생성
        Taxi taxi1 = getTaxiInstance();
        Taxi taxi2 = getTaxiInstance();
        // 각 번호가 다른지 확인
        System.out.println("taxi1 / taxi2 : " + taxi1.getNumber() + " / " + taxi2.getNumber());
        // 출력
        System.out.println("주유량: " + taxi1.getFuel());
        if (!taxi1.getStatus()){
            System.out.println("운행 불가");
        }
        else{
            System.out.println("운행 중");
        }
        System.out.println("택시 LED 상태 의미하는 코드 추가 구현");
        System.out.println("택시 LED : " + taxiRunService.passengerInfo(taxi1));
        taxiRunService.passengerRide(taxi1, 2);
        taxi1.setDestination("서울역");
        taxi1.setDistanceToDestination(2);

        System.out.println("탑승 승객 수: " + taxi1.getPresentPassenger());
        System.out.println("잔여 승객 수: " + (taxi1.getMaxPassenger() - taxi1.getPresentPassenger()));
        System.out.println("기본 요금 확인: " + taxi1.getBasicFare());
        System.out.println("목적지: " + taxi1.getDestination());
        System.out.println("목적지까지 거리(km): " + taxi1.getDistanceToDestination());
        System.out.println("지불할 요금: " + taxiRunService.fareCalc(taxi1));
        System.out.println("택시 LED 상태 의미하는 코드 추가 구현");
        System.out.println("택시 LED : " + taxiRunService.passengerInfo(taxi1));

        taxiRunService.changeFuel(taxi1, -80);
        taxiRunService.payment(taxi1, taxiRunService.fareCalc(taxi1));
        System.out.println("주유량: " + taxi1.getFuel());
        System.out.println("누적요금: " + taxi1.getAccumulatedFare());

        System.out.println("택시 LED 상태 의미하는 코드 추가 구현");
        System.out.println("택시 LED : " + taxiRunService.passengerInfo(taxi1));
        taxiRunService.passengerRide(taxi1, 5);
        taxiRunService.passengerRide(taxi1, 3);
        taxi1.setDestination("구로디지털단지역");
        taxi1.setDistanceToDestination(12);

        System.out.println("탑승 승객 수: " + taxi1.getPresentPassenger());
        System.out.println("잔여 승객 수: " + (taxi1.getMaxPassenger() - taxi1.getPresentPassenger()));
        System.out.println("기본 요금 확인: " + taxi1.getBasicFare());
        System.out.println("목적지: " + taxi1.getDestination());
        System.out.println("목적지까지 거리(km): " + taxi1.getDistanceToDestination());
        System.out.println("지불할 요금: " + taxiRunService.fareCalc(taxi1));
        System.out.println("택시 LED 상태 의미하는 코드 추가 구현");
        System.out.println("택시 LED : " + taxiRunService.passengerInfo(taxi1));

        taxiRunService.changeFuel(taxi1, -20);
        taxiRunService.payment(taxi1, taxiRunService.fareCalc(taxi1));
        System.out.println("택시 LED 상태 의미하는 코드 추가 구현");
        System.out.println("택시 LED : " + taxiRunService.passengerInfo(taxi1));

        System.out.println("주유량: " + taxi1.getFuel());
        System.out.println("누적요금: " + taxi1.getAccumulatedFare());
        if (!taxi1.getStatus()){
            System.out.println("운행 불가");
        }
        else{
            System.out.println("운행 중");
        }
    }

    public static void main(String[] args) {
        test_bus();
        test_taxi();
    }
}
