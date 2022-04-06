import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;

import java.io.IOException;

public class ModbusServiceImpl implements ModbusService {
    @Override
    public int[] readRegister(int registerId, String modbusIp, int port) {
        int[] response = new int[1];

        ModbusClient modbusClient = new ModbusClient(modbusIp, port);

        try {
            modbusClient.Connect();
            response = modbusClient.ReadInputRegisters(registerId, 0);
        } catch (IOException | ModbusException e) {
            e.printStackTrace();
        }
        try {
            modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public int[] writeRegister(int registerId, String modbusIp, int port, int registerValue) {
        int[] response = new int[1];
        ModbusClient modbusClient = new ModbusClient(modbusIp, port);
        try {
            modbusClient.Connect(modbusIp, port);
            modbusClient.WriteSingleRegister(registerId, registerValue);
            response = modbusClient.ReadInputRegisters(5, 0);
        } catch (IOException | ModbusException e) {
            e.printStackTrace();
        }
        try {
            modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}
