package Service;

public interface IHomeManager {
    public void initialize(PollutionMeterImpl gettingDataFromAirQualitySensor, AirRecuperatorImpl airRecuperator);
    public void checkAirQualityAndManageAirRecuperator();
}
