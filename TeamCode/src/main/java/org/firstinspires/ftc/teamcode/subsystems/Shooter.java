package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter extends SubsystemBase {
    private Motor shooterMotor;

    public Shooter(HardwareMap map, String motorName) {
        shooterMotor = new Motor(map, motorName);
        shooterMotor.setRunMode(Motor.RunMode.RawPower);
    }

    public void run(double speed) {
        shooterMotor.set(speed);
    }

    public void stop() {
        shooterMotor.stopMotor();
    }
}
