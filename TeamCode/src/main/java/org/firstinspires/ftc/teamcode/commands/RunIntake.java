package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class RunIntake extends CommandBase {

    private Intake subsystem;

    private double speed;

    public RunIntake(Intake _subsystem, double _speed) {
        subsystem = _subsystem;
        addRequirements(subsystem);
        speed = _speed;
    }

    @Override
    public void initialize() {
        subsystem.run(speed);
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stop();
    }
}
