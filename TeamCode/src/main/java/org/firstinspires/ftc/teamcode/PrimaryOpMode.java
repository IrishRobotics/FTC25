package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.RunShooter;
import org.firstinspires.ftc.teamcode.commands.UserDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@TeleOp(name = "PrimaryOpMode", group= "NormalOpModes")
public class PrimaryOpMode extends CommandOpMode {
    private Shooter shooter;
    private Drivetrain drivetrain;

    private GamepadEx driverOp;
    private GamepadEx coOp;

    @Override
    public void initialize() {
        driverOp = new GamepadEx(gamepad1);
        coOp = new GamepadEx(gamepad2);

        drivetrain = new Drivetrain(hardwareMap, "frontLeftDrive", "frontRightDrive", "backLeftDrive", "backRightDrive");
        drivetrain.setDefaultCommand(new UserDrive(drivetrain, driverOp));

        shooter = new Shooter(hardwareMap, "shooterMotor");
        coOp.getGamepadButton(GamepadKeys.Button.A).whileHeld(new RunShooter(shooter, 1));
    }
}
