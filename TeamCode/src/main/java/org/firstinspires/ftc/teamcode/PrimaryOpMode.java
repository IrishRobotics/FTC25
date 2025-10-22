package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.RunShooter;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@TeleOp(name = "PrimaryOpMode", group= "NormalOpModes")
public class PrimaryOpMode extends OpMode {
    private Motor fL, fR, bL, bR;
    private MecanumDrive drive;
    private Shooter shooter;
    private GamepadEx driverOp;

    private GamepadEx coOp;

    @Override
    public void init() {
        fL = new Motor(hardwareMap, "frontLeftDrive");
        fR = new Motor(hardwareMap, "frontRightDrive");
        bL = new Motor(hardwareMap, "backLeftDrive");
        bR = new Motor(hardwareMap, "backRightDrive");

        drive = new MecanumDrive(fL, fR, bL, bR);
        driverOp = new GamepadEx(gamepad1);
        coOp = new GamepadEx(gamepad2);

        shooter = new Shooter(hardwareMap, "shooterMotor");

        coOp.getGamepadButton(GamepadKeys.Button.A).whileHeld(new RunShooter(shooter, 1));
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
