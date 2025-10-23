package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter extends SubsystemBase {
    private final Motor shooterMotor;

    public Shooter(HardwareMap map, String motorName) {
        shooterMotor = new Motor(map, motorName);
        shooterMotor.setRunMode(Motor.RunMode.RawPower);
    }

    public void run(double speed) {
        // Clamp speed to valid motor range [-1.0, 1.0]
        double clampedSpeed = Math.max(-1.0, Math.min(1.0, speed));
        shooterMotor.set(clampedSpeed);
    }

    public void stop() {
        shooterMotor.stopMotor();
    }
}
