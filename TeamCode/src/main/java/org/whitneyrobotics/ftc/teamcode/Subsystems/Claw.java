package org.whitneyrobotics.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    public Servo clawleft;
    public Servo clawright;

    public ClawState leftposition = ClawState.OPEN;
    public ClawState rightposition = ClawState.OPEN;



    public Claw(HardwareMap hm) {
        clawleft = hm.get(Servo.class, "clawleft");
        clawright = hm.get(Servo.class, "clawright");
    }
    public enum ClawState {
        OPEN(0.15, 0.85),
        CLOSE(0.4, 0.6);

        public double leftpos;
        public double rightpos;
        ClawState(double leftpos, double rightpos) {
            this.leftpos=leftpos;
            this.rightpos=rightpos;
        }
    }

    public void update(){
        leftposition = Claw.ClawState.values()[(leftposition.ordinal() + 1) % 2];
        rightposition = Claw.ClawState.values()[(rightposition.ordinal() + 1 ) % 2];
    }

    public void run(){
        clawleft.setPosition(leftposition.leftpos);
        clawright.setPosition(rightposition.rightpos);
    }





}
