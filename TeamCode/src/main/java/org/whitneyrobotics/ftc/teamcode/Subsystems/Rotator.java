package org.whitneyrobotics.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Rotator {
    public DcMotor rotator;

    Rotator(HardwareMap hardwareMap){
        rotator = hardwareMap.get(DcMotorEx.class, "rotator");
        rotator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void run(double powerInput){
        rotator.setPower(powerInput);
    }
}
