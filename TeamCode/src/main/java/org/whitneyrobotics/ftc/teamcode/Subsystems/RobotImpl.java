package org.whitneyrobotics.ftc.teamcode.Subsystems;


import static com.jakewharton.threetenabp.AndroidThreeTen.init;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.whitneyrobotics.ftc.teamcode.Subsystems.Alliance;

import org.whitneyrobotics.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;
import org.whitneyrobotics.ftc.teamcode.RoadRunner.drive.StandardTrackingWheelLocalizer;

import java.util.ArrayList;

public class RobotImpl {

    private static RobotImpl instance = null;

    public Alliance alliance = Alliance.RED;

    public static RobotImpl getInstance(){
        return instance;
    }

    public static RobotImpl getInstance(HardwareMap hardwareMap){
        init(hardwareMap);
        return instance;
    }

    public static void init(HardwareMap hardwareMap){
        instance = new RobotImpl(hardwareMap);
    }

    public SampleMecanumDrive drive;

    public IntakeServo intake;

    public Rotator rotator;

    public Claw claw;

    public StandardTrackingWheelLocalizer localizer;

    private RobotImpl(HardwareMap hardwareMap){
        intake = new IntakeServo(hardwareMap);
        rotator = new Rotator(hardwareMap);
        claw = new Claw(hardwareMap);
        drive = new SampleMecanumDrive(hardwareMap);
        localizer = new StandardTrackingWheelLocalizer(hardwareMap, new ArrayList<>(), new ArrayList<>());
    }

    public void switchAlliance(){
        alliance = alliance == Alliance.RED ? Alliance.BLUE : Alliance.RED;
    }
    public void teleOpInit(){
        Pose2d poseMemory = localizer.getPoseEstimate();

        drive.setPoseEstimate(poseMemory);
    }

    public void update(){
        drive.update();
        intake.update();
        claw.update();

    }
}
