package org.lattice.shiv;

import com.fazecast.jSerialComm.SerialPort;

public class TestConfig {
    public TestConfig(){
        System.out.println("Hello world in Test Config constructor");
    }

    public void testLib(){
        System.out.println("testLib() before lib executed");
        SerialPort[] serialPorts=SerialPort.getCommPorts();
        System.out.println("testLib() after lib executed");
    }
}
