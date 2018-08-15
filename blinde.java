package nxtblindes;

import nxtblindes.BLINDESTATE;
import lejos.nxt.ButtonListener;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

public class blinde implements lejos.nxt.ButtonListener{

	private static final int minPosition = 0;
	private static final int maxPosition = 100;

	public int maxAngle = 360;

	private lejos.nxt.NXTRegulatedMotor motor;

	public boolean reversed = false;

	public blinde(lejos.nxt.NXTRegulatedMotor pMotor, int pMaxAngle) {
		//init the blinde
		motor = pMotor;
		motor.setSpeed(motor.getMaxSpeed());
		motor.resetTachoCount();

		maxAngle = pMaxAngle;
	}

	/**
		Return: Position from 0-100
	*/
	public int getPosition() {
		return minPosition + (reversed ? -1 : 1) * motor.getTachoCount() * maxPosition / maxAngle;
	}

	/**
		Set the Position
		position: int 0-100
	*/
	public void setPosition(int pPosition) {
		// TODO
		int tachoPos = (pPosition - minPosition) * maxAngle / maxPosition;
		motor.rotateTo((reversed ? -1 : 1) * tachoPos, true);
	}

	/**
		Return: State (enum)
	*/
	public BLINDESTATE getState() {
		// TODO
		if(motor.isStalled()) {
			return BLINDESTATE.IDLING;
		}
		else if(motor.isMoving()) {
			if(motor.getLimitAngle() > motor.getTachoCount()) {
				return (reversed) ? BLINDESTATE.OPENING : BLINDESTATE.CLOSING;
			}
			else {
				return (reversed) ? BLINDESTATE.CLOSING : BLINDESTATE.OPENING;
			}
		}
		return BLINDESTATE.IDLING;
	}

	/**
	 * Buttons LEFT and RIGTH move the blindes up and down.
	 * Button ENTER moves the blindes up if the are somehow closed and fully down, if they are completly open
	 */
	public void buttonPressed(Button b) {
		if(b == lejos.nxt.Button.LEFT){
			if(reversed) {
				motor.backward();
			}
			else {
				motor.forward();
			}
		}
		else if(b == lejos.nxt.Button.RIGHT){
			if(! reversed) {
				motor.backward();
			}
			else {
				motor.forward();
			}
		}
		else if(b == lejos.nxt.Button.ENTER){
			if(getPosition() > minPosition) {
				setPosition(minPosition);
				System.out.println("Opening to 0%");		
			}
			else {
				setPosition(maxPosition);
				System.out.println("Closing to 100%");		
			}
		}
	}
	public void buttonReleased(Button b) {
		if(b != lejos.nxt.Button.ENTER) {
			motor.flt(true);
			System.out.println("Position: " + getPosition() + "%");		
		}
	}
}