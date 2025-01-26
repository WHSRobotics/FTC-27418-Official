package org.whitneyrobotics.ftc.teamcode.OpMode.TeleOp;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.robot.Robot;

import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import org.whitneyrobotics.ftc.teamcode.Libraries.Utilities.Functions;
import org.whitneyrobotics.ftc.teamcode.Subsystems.RobotImpl;

import java.util.function.UnaryOperator;

@TeleOp(name = "Teleop", group = "A")
public class WHSTeleOp extends OpModeEx {

    private final UnaryOperator<Float> scalingFunctionDefault = x -> (float)Math.pow(x, 3);

    boolean fieldCentric = false;
    RobotImpl robot;

    @Override
    public void initInternal() {
        robot = RobotImpl.getInstance(hardwareMap);
        robot.drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dashboardTelemetry.setMsTransmissionInterval(25);
        telemetryPro.useDashboardTelemetry(dashboardTelemetry);

        gamepad1.TRIANGLE.onPress(e -> robot.switchAlliance());

        robot.teleOpInit();
    }

    @Override
    protected void loopInternal() {
        robot.update();

        gamepad1.BUMPER_RIGHT.onPress(() -> fieldCentric = !fieldCentric);

        float brakePower = gamepad1.LEFT_TRIGGER.value();
        robot.rotator.run(gamepad2.RIGHT_STICK_Y.value()*0.5);
        gamepad2.CROSS.onPress(e -> robot.intake.run());
        gamepad2.TRIANGLE.onPress(e -> robot.claw.run());

        UnaryOperator<Float> scaling = scalingFunctionDefault;
        if (!robot.drive.isBusy()) robot.drive.setWeightedDrivePower(
                Functions.rotateVectorCounterclockwise(new Pose2d(
                        scaling.apply(gamepad1.LEFT_STICK_Y.value()),
                        scaling.apply(gamepad1.LEFT_STICK_X.value()),
                        scaling.apply(gamepad1.RIGHT_STICK_X.value())
                ).times(1-brakePower), (fieldCentric ? -robot.drive.getPoseEstimate().getHeading()+robot.alliance.headingAngle : 0))
        );


    }
}
