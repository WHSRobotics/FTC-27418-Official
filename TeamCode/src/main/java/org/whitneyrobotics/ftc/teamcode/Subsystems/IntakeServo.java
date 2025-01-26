package org.whitneyrobotics.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeServo {
    public static Servo intake;

    public intakeState position = intakeState.UP;


    public IntakeServo(HardwareMap hardwareMap){
        intake = hardwareMap.get(Servo.class, "intake");
    }

    public enum intakeState{
        UP(0.8),
        DOWN(0.2);

        public double servoPosition;

        intakeState(double servoPosition){
            this.servoPosition = servoPosition;
        }

    }




    public void update(){
        position = intakeState.values()[(position.ordinal() + 1) % 2];
    }

    public void run(){
        intake.setPosition(position.servoPosition);
    }


}
