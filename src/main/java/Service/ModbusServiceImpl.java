package Service;

import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;

import java.io.IOException;

public class ModbusServiceImpl implements ModbusService {
    @Override
    public int readRegister(int registerId, String modbusIp, int port) {
        int[] responseArray = new int[1];

        ModbusClient modbusClient = new ModbusClient(modbusIp, port);

        try {
            modbusClient.Connect();
            responseArray = modbusClient.ReadInputRegisters(registerId, 0);
        } catch (IOException | ModbusException e) {
            e.printStackTrace();
        }
        try {
            modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int response = responseArray[0];
        return response;
    }

    @Override
    public int writeRegister(int registerId, String modbusIp, int port, int registerValue) {
        int[] responseArray = new int[1];
        ModbusClient modbusClient = new ModbusClient(modbusIp, port);
        try {
            modbusClient.Connect(modbusIp, port);
            modbusClient.WriteSingleRegister(registerId, registerValue);
            responseArray = modbusClient.ReadInputRegisters(5, 0);
        } catch (IOException | ModbusException e) {
            e.printStackTrace();
        }
        try {
            modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int response = responseArray[0];
        return response;
    }


}
