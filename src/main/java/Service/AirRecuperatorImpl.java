package Service;

import enums.AirRecuperatorStatus;

public class AirRecuperatorImpl implements AirRecuperator {
    @Override
    public AirRecuperatorStatus getStatus() {
        AirRecuperatorStatus status;
        ModbusServiceImpl mB = new ModbusServiceImpl();
        String modbusIp = "192.168.0.60";
        int modbusPort = 502;


        // int response = mB.readRegister(5 , modbusIp, modbusPort);
        int response = 2;

        switch (response){
            case 1:
                System.out.println("Air Recuperator mode is Away");
                return AirRecuperatorStatus.AWAY;
            case 2:
                System.out.println("Air Recuperator mode is Normal");
                return AirRecuperatorStatus.NORMAL;
            case 3:
                System.out.println("Air Recuperator mode is Itensive");
                return AirRecuperatorStatus.INTENSIVE;
            case 4:
                System.out.println("Air Recuperator mode is Boost");
                return AirRecuperatorStatus.BOOST;
            case 10:
                System.out.println("Air Recuperator mode is Disabled");
                return AirRecuperatorStatus.DISABLED;
        }


        return null;
    }

    @Override
    public void setStatus(AirRecuperatorStatus status) {
        //Register 1 ON/OFF status R/W unsigned char 0 - 1 Off = 0, On = 1
        //Register 5 Current mode R/W unsigned char 0 - 10 WRITE ONLY: Away = 1, Normal = 2, Intensive = 3, Boost = 4
        // Register 5 Current mode Read only Off = 10
        ModbusServiceImpl mB = new ModbusServiceImpl();
        String modbusIp = "192.168.0.60";
        int modbusPort = 502;

        switch(status) {
            case DISABLED:
                System.out.println("Air Recuperator mode changing to Disabled");
                mB.writeRegister(1, modbusIp, modbusPort, 0);
                System.out.println("Air Recuperator mode is Disabled");
                break;
            case AWAY:
                System.out.println("Air Recuperator mode changing to Away");
                mB.writeRegister(1, modbusIp, modbusPort, 1);
                mB.writeRegister(5, modbusIp, modbusPort, 1);
                System.out.println("Air Recuperator mode is Away");
                break;
            case NORMAL:
                System.out.println("Air Recuperator mode changing to Normal");
                mB.writeRegister(1, modbusIp, modbusPort, 1);
                mB.writeRegister(5, modbusIp, modbusPort, 2);
                System.out.println("Air Recuperator mode is Normal");
                break;
            case INTENSIVE:
                System.out.println("Air Recuperator mode changing to Itensive");
                mB.writeRegister(1, modbusIp, modbusPort, 1);
                mB.writeRegister(5, modbusIp, modbusPort, 3);
                System.out.println("Air Recuperator mode is Itensive");
                break;
            case BOOST:
                System.out.println("Air Recuperator mode changing to Boost");
                mB.writeRegister(1, modbusIp, modbusPort, 1);
                mB.writeRegister(5, modbusIp, modbusPort, 4);
                System.out.println("Air Recuperator mode is Boost");
                break;
        }

    }
}
