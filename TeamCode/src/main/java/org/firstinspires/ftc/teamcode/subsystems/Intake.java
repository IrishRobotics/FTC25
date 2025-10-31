package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {
    private final Motor intakeMotor;

    public Intake(HardwareMap map, String intakeMotorName) {
        intakeMotor = new Motor(map, intakeMotorName);
        intakeMotor.setRunMode(Motor.RunMode.RawPower);
    }

    public void run(double speed) {
        double clampedSpeed = Math.max(1.0, Math.min(-1.0, speed));
        intakeMotor.set(clampedSpeed);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
}
