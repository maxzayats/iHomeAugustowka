import Service.AirRecuperatorImpl;
import Service.IHomeManagerImpl;
import Service.PollutionMeterImpl;
import model.AirQuality;

public class Main {
    public static void main(String[] args) {
        PollutionMeterImpl pollutionMeter = new PollutionMeterImpl();
        AirQuality aQ = pollutionMeter.checkAirQuality();
        AirRecuperatorImpl airRecuperator = new AirRecuperatorImpl();
        IHomeManagerImpl iHomeManager = new IHomeManagerImpl();



        System.out.println(aQ.getPM1());
        System.out.println(aQ.getPM2dot5());
        System.out.println(aQ.getPM10());
        System.out.println(aQ.getColor());

        iHomeManager.checkAirQualityAndManageAirRecuperator();

        airRecuperator.getStatus();
    }
}
