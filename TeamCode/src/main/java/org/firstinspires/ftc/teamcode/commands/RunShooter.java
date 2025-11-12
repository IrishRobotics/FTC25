package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class RunShooter extends CommandBase {
    private final Shooter subsystem;
    private final double shooterSpeed, rampSpeed;

    public RunShooter(Shooter _subsystem, double _shooterSpeed, double _rampSpeed) {
        subsystem = _subsystem;
        addRequirements(subsystem);
        shooterSpeed = _shooterSpeed;
        rampSpeed = _rampSpeed;
    }

    @Override
    public void initialize() {
        subsystem.runBase(shooterSpeed, rampSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stop();
    }
}
