package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter extends SubsystemBase {
    private final Motor shooterMotor, rampMotorOne, rampMotorTwo;

    public Shooter(HardwareMap map, String shooterMotorName, String rampMotorOneName, String rampMotorTwoName) {
        shooterMotor = new Motor(map, shooterMotorName);
        shooterMotor.setRunMode(Motor.RunMode.RawPower);
        rampMotorOne = new Motor(map, rampMotorOneName);
        rampMotorOne.setRunMode(Motor.RunMode.RawPower);
        rampMotorTwo = new Motor(map, rampMotorTwoName);
        rampMotorTwo.setRunMode(Motor.RunMode.RawPower);
    }

    public void runBase(double shooterSpeed, double rampSpeedOne) {
        // Clamp speed to valid motor range [-1.0, 1.0]
        double baseSpeed = Math.max(-1.0, Math.min(1.0, shooterSpeed));
        double _rampSpeed = Math.max(-1.0, Math.min(1.0, rampSpeedOne));
        shooterMotor.set(baseSpeed);
        rampMotorOne.set(_rampSpeed);
        rampMotorTwo.set(_rampSpeed * -1.0);
    }

    public void stop() {
        shooterMotor.stopMotor();
        rampMotorOne.stopMotor();
        rampMotorTwo.stopMotor();
    }
}
