// Written by: Anik Koirala & Derek Luc
// Refactored by: Christopher Gholmieh

// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Ascend;


// Imports:
import org.whitneyrobotics.ftc.teamcode.Library.Subsystem.Subsystem;
import org.whitneyrobotics.ftc.teamcode.Library.Channel.Channel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;


// Ascend:
public class Ascend implements Subsystem {
    // Variables (Declaration):
    // Slides:
    public DcMotor right_linear_slide, left_linear_slide;

    // Constructor:
    public Ascend(HardwareMap hardware_map) {
        // Variables (Assignment):
        // Slides:
        right_linear_slide = hardware_map.get(DcMotor.class, "right-vertical-slide");
        left_linear_slide = hardware_map.get(DcMotor.class, "left-vertical-slide");
    }

    // Methods:
    private void set_power(double power) {
        // Slides:
        // Right:
        right_linear_slide.setPower(power);

        // Left:
        left_linear_slide.setPower(power);
    }

    @Override
    public void update(Channel channel) {
        // Verification:
        if (!channel.gamepad_two_options)  {
            set_power(0.0);
        }

        // Logic:
        set_power(-channel.gamepad_two_left_stick_y);
    }
}