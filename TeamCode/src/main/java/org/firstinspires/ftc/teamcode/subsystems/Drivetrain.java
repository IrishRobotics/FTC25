package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.GyroEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.kinematics.HolonomicOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveWheelSpeeds;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;

import org.firstinspires.ftc.teamcode.Constants;

public class Drivetrain extends SubsystemBase {
    private final Motor fL, fR, bL, bR;
    private final Motor.Encoder fLE, fRE, bLE, bRE;

    private final MecanumDrive drive;
    private final MecanumDriveOdometry odometry;
    private final GyroEx gyroscope;
    private Pose2d pose;

    public Drivetrain(HardwareMap hardwareMap, String flName, String frName, String blName, String brName, GyroEx gyroscope) {
        fL = new Motor(hardwareMap, flName);
        fLE = fL.encoder;
        fR = new Motor(hardwareMap, frName);
        fRE = fR.encoder;
        bL = new Motor(hardwareMap, blName);
        bLE = bL.encoder;
        bR = new Motor(hardwareMap, brName);
        bRE = bR.encoder;
        this.gyroscope = gyroscope;

        drive = new MecanumDrive(fL, fR, bL, bR);

        odometry = new MecanumDriveOdometry(
                        Constants.Drivetrain.kinematics, gyroscope.getRotation2d(),
                        new Pose2d(0.0, 0.0, new Rotation2d()
                        ));
    }

    @Override
    public void periodic(){
        MecanumDriveWheelSpeeds wheelSpeeds = new MecanumDriveWheelSpeeds(
                        fLE.getRate(), fRE.getRate(),
                        bLE.getRate(), bRE.getRate()
                );

        pose = odometry.updateWithTime(System.currentTimeMillis()/1000.0, gyroscope.getRotation2d(), wheelSpeeds);
    }

    public void move(double strafe, double forward, double rotate) {
        drive.driveRobotCentric(strafe, forward, rotate);
    }

    public Pose2d getPose() {return pose;}

    public void stop() {
        drive.stop();
    }
}
