package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.RunIntake;
import org.firstinspires.ftc.teamcode.commands.RunShooter;
import org.firstinspires.ftc.teamcode.commands.UserDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@TeleOp(name = "PrimaryOpMode", group = "NormalOpModes")
public class PrimaryOpMode extends CommandOpMode {
    private Shooter shooter;
    private Intake intake;
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
        shooter = new Shooter(hardwareMap, Constants.Shooter.shooterMotorName, Constants.Shooter.rampMotorName);
        register(shooter);
        intake = new Intake(hardwareMap, Constants.Intake.intakeMotorName);
        register(intake);
        coOp.getGamepadButton(GamepadKeys.Button.A).whileHeld(
                new RunShooter(shooter, Constants.Shooter.defaultSpeed));
        coOp.getGamepadButton(GamepadKeys.Button.B).whileHeld(
                new RunIntake(intake, Constants.Intake.defaultSpeed));
    }
}
