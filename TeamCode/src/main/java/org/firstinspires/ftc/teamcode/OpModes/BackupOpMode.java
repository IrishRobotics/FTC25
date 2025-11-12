package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.RunShooter;
import org.firstinspires.ftc.teamcode.commands.UserDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@TeleOp(name = "BackupOpMode", group = "NormalOpModes")
public class BackupOpMode extends CommandOpMode {
    private Shooter shooter;
    private Drivetrain drivetrain;

    private GamepadEx driverOp;
    private GamepadEx coOp;

    @Override
    public void initialize() {
        driverOp = new GamepadEx(gamepad1);
        coOp = new GamepadEx(gamepad2);

        drivetrain = new Drivetrain(
                hardwareMap,
                Constants.Drivetrain.flMotorName,
                Constants.Drivetrain.frMotorName,
                Constants.Drivetrain.blMotorName,
                Constants.Drivetrain.brMotorName
        );
        drivetrain.setDefaultCommand(new UserDrive(drivetrain, driverOp));
        register(drivetrain);

        shooter = new Shooter(hardwareMap, Constants.Shooter.shooterMotorName, Constants.Shooter.rampMotorOneName, Constants.Shooter.rampMotorTwoName);
        register(shooter);
        coOp.getGamepadButton(GamepadKeys.Button.A).whileHeld(
                new RunShooter(shooter, Constants.Shooter.shooterSpeed, Constants.Shooter.rampSpeed));
    }
}