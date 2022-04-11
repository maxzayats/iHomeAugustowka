package Service;

import enums.AirRecuperatorStatus;

public class IHomeManagerImpl implements IHomeManager {
    @Override
    public void initialize(PollutionMeterImpl gettingDataFromAirQualitySensor, AirRecuperatorImpl airRecuperator) {
    }

    @Override
    public void checkAirQualityAndManageAirRecuperator() {
        PollutionMeterImpl pollutionMeter = new PollutionMeterImpl();
        String color = pollutionMeter.checkAirQuality().getColor();
        System.out.println();
        AirRecuperatorImpl airRecuperatorImpl = new AirRecuperatorImpl();
        switch (color) {
            //BLUE
            case "#0000ff":
                System.out.println("case blue");
                airRecuperatorImpl.setStatus(AirRecuperatorStatus.BOOST);
                break;

            //GREEN
            case "#00ff00":
                System.out.println("case green");
                airRecuperatorImpl.setStatus(AirRecuperatorStatus.INTENSIVE);
                break;

            //YELLOW
            case "#ffff00":
                System.out.println("case yellow");
                airRecuperatorImpl.setStatus(AirRecuperatorStatus.NORMAL);
                break;

            //ORANGE
            case "#FF8000":
                System.out.println("case orange");
                airRecuperatorImpl.setStatus(AirRecuperatorStatus.AWAY);
                break;

            //RED
            case "#ff0000":
                System.out.println("case red");
                airRecuperatorImpl.setStatus(AirRecuperatorStatus.DISABLED);
                break;

            //BROWN
            case "3":
                airRecuperatorImpl.setStatus(AirRecuperatorStatus.DISABLED);
                break;
        }
    }
}
