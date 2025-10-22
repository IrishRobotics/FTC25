package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "PrimaryOpMode", group= "NormalOpModes")
public class PrimaryOpMode extends OpMode {
    private Motor fL, fR, bL, bR;
    private MecanumDrive drive;
    private GamepadEx driverOp;

    @Override
    public void init() {
        fL = new Motor(hardwareMap, "frontLeftDrive");
        fR = new Motor(hardwareMap, "frontRightDrive");
        bL = new Motor(hardwareMap, "backLeftDrive");
        bR = new Motor(hardwareMap, "backRightDrive");

        drive = new MecanumDrive(fL, fR, bL, bR);
        driverOp= new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        drive.driveRobotCentric(
                driverOp.getLeftX(),
                driverOp.getLeftY(),
                driverOp.getRightX()
        );
    }
}
