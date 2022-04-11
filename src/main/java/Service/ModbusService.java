package Service;

public interface ModbusService {
public int readRegister(int registerId, String modbusIp, int port);
public int writeRegister(int registerId, String modbusIp, int port, int registerValue);
}
