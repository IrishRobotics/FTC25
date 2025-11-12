package org.firstinspires.ftc.teamcode.OpModes.learning;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Constants;

@TeleOp(name="Chase's OpMode", group = "Example OpMode")
public class ChaseFirstOpMode extends OpMode {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, Constants.Drivetrain.flMotorName);
        frontRightMotor = hardwareMap.get(DcMotor.class, Constants.Drivetrain.frMotorName);
        backLeftMotor = hardwareMap.get(DcMotor.class, Constants.Drivetrain.blMotorName);
        backRightMotor = hardwareMap.get(DcMotor.class, Constants.Drivetrain.brMotorName);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backLeftMotor.setPower(backLeftPower);
        backRightMotor.setPower(backRightPower);

        telemetry.addData("Status", "Running");
        telemetry.update();
    }
}
