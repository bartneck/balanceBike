package balanceBike;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.MindsensorsGlideWheelMRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

// My comment 
public class BalanceBike {
	private EV3LargeRegulatedMotor myMotor=new EV3LargeRegulatedMotor(MotorPort.A);
	private PIDController myPID = new PIDController(0, 10);
	private MindsensorsGlideWheelMRegulatedMotor myRotationSensor = new MindsensorsGlideWheelMRegulatedMotor(SensorPort.S1);
	
	public BalanceBike(){
		// set PID controller Parameters
		
		// set PID_KP 
		myPID.setPIDParam(0, 1);
		
		// set PID_KI
		myPID.setPIDParam(1, 1);
		
		// set PID_KD
		myPID.setPIDParam(2, 0.5f);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalanceBike myBike = new BalanceBike();
		myBike.mainLoop();
	}
	
	private void mainLoop() {
		myMotor.setSpeed(myPID.doPID((int) myRotationSensor.getPosition()));
	}

}
