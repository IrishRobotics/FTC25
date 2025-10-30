package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {
    // intakeMotor is the one that runs the intake, rampMotor is the one on the ramp.
    private final Motor intakeMotor, rampMotor;

    public Intake(HardwareMap hardwareMap, String intakeMotorName, String rampMotorName) {
        intakeMotor = new Motor(hardwareMap, intakeMotorName);
        rampMotor = new Motor(hardwareMap, rampMotorName);

        intakeMotor.setRunMode(Motor.RunMode.RawPower);
        rampMotor.setRunMode(Motor.RunMode.RawPower);
    }

    public void run(double speed) {
        double clampedSpeed = Math.max(-1.0, Math.min(1.0, speed));
        intakeMotor.set(clampedSpeed);
        rampMotor.set(clampedSpeed);
    }

    public void stop() {
        intakeMotor.stopMotor();
        rampMotor.stopMotor();
    }
}
