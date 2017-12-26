package balanceBike;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

// My comment 
public class BalanceBike {
	private EV3LargeRegulatedMotor myMotor=new EV3LargeRegulatedMotor(MotorPort.A);
	private PIDController myPID = new PIDController(0, 0);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
