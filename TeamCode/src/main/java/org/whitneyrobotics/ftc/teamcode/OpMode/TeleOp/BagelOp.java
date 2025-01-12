// Written by: Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.OpMode.TeleOp;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import org.whitneyrobotics.ftc.teamcode.Subsystems.Implementation;
import org.whitneyrobotics.ftc.teamcode.Library.Channel.Channel;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


// TeleOp:
@TeleOp(name = "27418-Bagel", group = "27418-TeleOp")
public class BagelOp extends OpModeEx  {
    // Variables (Declaration):
    // Implementation:
    public Implementation implementation;

    // Channel:
    public Channel channel;

    // Methods:
    /**
     * @brief Records the appropriate telemetry fields from the channel class.
     *
     * @param channel The channel class that contains the data that will be recorded.
     */
    public void record_telemetry(Channel channel) {
        // Telemetry:
        // Gamepad (One):
        telemetryPro.addData("gamepad-one-right-bumper", channel.gamepad_one_right_bumper);
        telemetryPro.addData("gamepad-one-left-bumper", channel.gamepad_one_left_bumper);

        telemetryPro.addData("gamepad-one-left-stick-x", channel.gamepad_one_left_stick_x);
        telemetryPro.addData("gamepad-one-left-stick-y", channel.gamepad_one_left_stick_y);

        telemetryPro.addData("gamepad-one-right-stick-x", channel.gamepad_one_right_stick_x);
        telemetryPro.addData("gamepad-one-right-stick-y", channel.gamepad_two_right_stick_y);

        telemetryPro.addData("gamepad-one-options", channel.gamepad_one_options);

        // Gamepad (Two):
        telemetryPro.addData("gamepad-two-right-bumper", channel.gamepad_two_right_bumper);
        telemetryPro.addData("gamepad-two-left-bumper", channel.gamepad_two_left_bumper);

        telemetryPro.addData("gamepad-two-left-stick-x", channel.gamepad_two_left_stick_x);
        telemetryPro.addData("gamepad-two-left-stick-y", channel.gamepad_one_left_stick_y);

        telemetryPro.addData("gamepad-two-right-stick-x", channel.gamepad_two_right_stick_x);
        telemetryPro.addData("gamepad-two-right-stick-y", channel.gamepad_two_right_stick_y);

        telemetryPro.addData("gamepad-two-options", channel.gamepad_two_options);

        // Odometry:
        double[] odometry_values = implementation.mecanum.odometry.get_odometry_values();

        telemetryPro.addData("odometry-x", odometry_values[0]);
        telemetryPro.addData("odometry-y", odometry_values[1]);

        telemetryPro.addData("odometry-heading", odometry_values[2]);

        // Logic:
        telemetryPro.update();
    }

    // Initialization:
    @Override
    public void initInternal() {
        // Variables (Assignment):
        // Implementation:
        implementation = new Implementation(hardwareMap);

        // Channel:
        channel = new Channel(gamepad1, gamepad2);
    }

    // Loop:
    @Override
    public void loopInternal() {
        // Channel:
        channel.update(gamepad1, gamepad2);

        // Telemetry:
        record_telemetry(channel);

        // Implementation:
        implementation.update(channel);
    }
}