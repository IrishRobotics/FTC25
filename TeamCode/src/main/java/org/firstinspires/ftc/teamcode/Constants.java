package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;

public final class Constants {
    public static class Drivetrain {
        public static final String flMotorName = "frontLeftDrive";
        public static final String frMotorName = "frontRightDrive";
        public static final String blMotorName = "backLeftDrive";
        public static final String brMotorName = "backRightDrive";

        private static final double length = 0.2873375;
        private static final  double width = 0.3444875;
        public static final Translation2d frontLeftLocation =
                new Translation2d(length/2, width/2);
        public static final Translation2d frontRightLocation =
                new Translation2d(length/2, -width/2);
        public static final Translation2d backLeftLocation =
                new Translation2d(-length/2, width/2);
        public static final Translation2d backRightLocation =
                new Translation2d(-length/2, -width/2);

        public static final MecanumDriveKinematics kinematics = new MecanumDriveKinematics
                (
                        frontLeftLocation, frontRightLocation,
                        backLeftLocation, backRightLocation
                );
    }

    public static class Shooter {
        public static final String shooterMotorName = "shooterMotor";
        public static final String rampMotorOneName = "rampMotorOne";
        public static final String rampMotorTwoName = "rampMotorTwo";
        public static final double shooterSpeed = 1;
        public static final double rampSpeed = 0.5;
    }

    public static class Intake {
        public static final String intakeMotorName = "intakeMotor";
        public static final double defaultSpeed = 0.5;
    }
}
