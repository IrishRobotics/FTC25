package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class UserDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private final GamepadEx gamepad;

    public UserDrive(Drivetrain drivetrain, GamepadEx gamepad) {
        this.drivetrain = drivetrain;
        this.gamepad = gamepad;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.move(
                gamepad.getLeftX(),
                gamepad.getLeftY(),
                gamepad.getRightY()
        );
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
