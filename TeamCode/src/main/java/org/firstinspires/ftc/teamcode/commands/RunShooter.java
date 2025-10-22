package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class RunShooter extends CommandBase {
    private Shooter subsystem;
    private double speed;

    public RunShooter(Shooter _subsystem, double _speed) {
       subsystem = _subsystem;
       addRequirements(subsystem);
       speed = _speed;
    }

    @Override
    public void initialize() {
        subsystem.run(speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stop();
    }
}
