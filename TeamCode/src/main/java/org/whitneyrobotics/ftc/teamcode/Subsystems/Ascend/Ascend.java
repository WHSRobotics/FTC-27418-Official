// Written By Anik Koirala and Derek Luc
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Ascend;

// Imports:
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.whitneyrobotics.ftc.teamcode.Library.Subsystem.Subsystem;
import org.whitneyrobotics.ftc.teamcode.Library.Channel.Channel;

// Class:
public class Ascend implements Subsystem {
    // Variables (Declaration):
    // Left and Right Vertical Linear Slides:
    protected DcMotor left_vertical_linear_slides, right_vertical_linear_slides;

    // Variables (Assignment):
    // Status:
    public Status internal_status = Status.OPEN;

    // Toggle:
    public boolean toggle = true;

    // Enumerations:
    // Power:
    public enum Power {
        // Down:
        ASCEND_DOWN(0.0),

        // Up:
        ASCEND_UP (1.0);

        // Fields:
        public final double power;

        // Constructor:
        Power(double power) {
            this.power = power;
        }
    }

    // Status:
    public enum Status {
        CLOSED, OPEN;
    }

    // Constructor
    public Ascend(HardwareMap hardware_map) {
        // Variables (Definition):
        left_vertical_linear_slides = hardware_map.get(DcMotor.class, "left_vertical_linear_slides");
        right_vertical_linear_slides = hardware_map.get(DcMotor.class, "right_vertical_linear_slides");
    }

    // Methods:
    public void set_power(Power Power) {
        left_vertical_linear_slides.setPower(Power.power);
        right_vertical_linear_slides.setPower(Power.power);
    }

    @Override
    public void update(Channel channel) {
        // Toggle Switch:
        if (channel.gamepad_two_options) {
            toggle = !toggle;
        }
        // Logic:
        if (toggle) {
            internal_status = Status.CLOSED;

            set_power(Power.ASCEND_DOWN);
        } else {
            internal_status = Status.OPEN;

            set_power(Power.ASCEND_UP);
        }

        // Logic:
        switch (internal_status) {
            case CLOSED:
                set_power(Power.ASCEND_DOWN);
                break
            case OPEN:
                set_power(Power.ASCEND_UP);
        }


    }


}
