package org.whitneyrobotics.ftc.teamcode.Subsystems.Telemetry;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import android.graphics.Color;

import org.whitneyrobotics.ftc.teamcode.Extensions.TelemetryPro.LineItem;
import org.whitneyrobotics.ftc.teamcode.Extensions.TelemetryPro.TelemetryPro;

import java.util.ArrayList;

public class Telemetry {
    public TimeType timetype;

    public Telemetry(Modes mode){
        switch (mode) {
            case FULL:
                switch(timetype){
                    case EARLY:
                        telemetry.addData("hi", gamepad2.left_bumper?Color.rgb(255,0,0):Color.rgb(0,255,0));



                }

        }
    }






}
