package Service;

import enums.AirRecuperatorStatus;

public interface AirRecuperator {
    public AirRecuperatorStatus getStatus();
    public void setStatus(AirRecuperatorStatus status);
}
