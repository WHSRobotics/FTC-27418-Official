
// Written by: Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Library.Subsystem.Subsystem;
import org.whitneyrobotics.ftc.teamcode.Subsystems.Mecanum.Mecanum;
import org.whitneyrobotics.ftc.teamcode.Library.Channel.Channel;
import org.whitneyrobotics.ftc.teamcode.Subsystems.Claw.Claw;
import com.qualcomm.robotcore.hardware.HardwareMap;


// Implementation:
public class Implementation implements Subsystem {
    // Variables (Declaration):
    // Implementation:
    private static Implementation implementation;

    // Subsystems:
    public Mecanum mecanum;
    public Claw claw;

    // Constructor:
    public Implementation(HardwareMap hardware_map) {
        // Variables (Definition):
        // Mecanum:
        mecanum = new Mecanum(hardware_map);

        // Claw:
        claw = new Claw(hardware_map);
    }

    // Methods:
    public static Implementation getInstance(HardwareMap hardware_map) {
        if (implementation == null) {
            implementation = new Implementation(hardware_map);
        }

        return implementation;
    }

    public void update(Channel channel) {
        // Mecanum:
        mecanum.update(channel);

        // Claw:
        claw.update(channel);
    }
}