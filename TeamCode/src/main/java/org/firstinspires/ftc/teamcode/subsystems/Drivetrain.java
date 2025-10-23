package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain extends SubsystemBase {
    private final Motor fL, fR, bL, bR;
    private final MecanumDrive drive;

    public Drivetrain(HardwareMap hardwareMap, String flName, String frName, String blName, String brName) {
        fL = new Motor(hardwareMap, flName);
        fR = new Motor(hardwareMap, frName);
        bL = new Motor(hardwareMap, blName);
        bR = new Motor(hardwareMap, brName);

        drive = new MecanumDrive(fL, fR, bL, bR);
    }

    public void move(double strafe, double forward, double rotate) {
        drive.driveRobotCentric(strafe, forward, rotate);
    }

    public void stop() {
        drive.stop();
    }
}
