// Written by: Aarav Jain (reviewed by Anik Koirala):

// package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Arm;

// imports:
import org.whitneyrobotics.ftc.teamcode.Library.Subsystem.Subsystem;
import org.whitneyrobotics.ftc.teamcode.Library.Channel.Channel;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


// Class:
@TeleOp(name = "arm-27418", group = "arm-27418")
public class Arm implements Subsystem {
    // Variable (Declaration):
    // Position:
    double position = 0.0; // NOTE: 0 <= position <= 1

    // Servo:
    public Servo intake_arm;

    // Constructor:
    public Arm(HardwareMap hardware_map) {
        // Variables (Definition):
        // Servo:
        intake_arm = hardware_map.get(Servo.class, "intake-arm");
    }

    // Methods:
    @Override
    public void update(Channel channel) {
        // Variables (Assignment):
        // Position:
        position = clamp(
                0.0,
                position + (-channel.gamepad_two_left_stick_x)
                ,1.0
        );

        // Logic:
        intake_arm.setPosition(position);
    }

    public double clamp(double minimum, double value, double maximum) {
        if (value < minimum) {
            return minimum;
        }

        if (value > maximum) {
            return maximum;
        }

        return value;
    }
}