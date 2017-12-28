package balanceBike;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.MindsensorsGlideWheelMRegulatedMotor;
import lejos.hardware.port.MotorPort;
//import lejos.hardware.port.SensorPort;

// My comment 
public class BalanceBike {
	private EV3LargeRegulatedMotor myMotor=new EV3LargeRegulatedMotor(MotorPort.A);
	private PIDController myPID = new PIDController(0, 10);
	private MindsensorsGlideWheelMRegulatedMotor myRotationSensor = new MindsensorsGlideWheelMRegulatedMotor(MotorPort.B);
	
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
		myBike.setup();
		myBike.mainLoop();
	}
	
	private void mainLoop() {
		while (true) {
			System.out.println("R:" + myRotationSensor.getTachoCount()+ "M:"+myPID.doPID((int) myRotationSensor.getPosition()));
			int speed = myPID.doPID((int) myRotationSensor.getTachoCount());
			// right = negative values, left = positive values
			
			// if leans right must rotate clockwise/forward
			// if leans left must rotate counter clockwise/backwards
			
			if (speed <= 0) {
				// clockwise
				myMotor.forward();
				myMotor.setSpeed(-speed);
			}
			else {
				// counter clockwise
				myMotor.backward();
				myMotor.setSpeed(speed);
			}
			//myMotor.setSpeed(myPID.doPID((int) myRotationSensor.getTachoCount()));
		}
	}
	
	private void setup() {
		// wait for pendulum to be in vertical position confirmed by user pressing button
		
	}

}
