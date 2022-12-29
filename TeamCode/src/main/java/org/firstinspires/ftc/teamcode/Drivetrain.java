package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain extends SubsystemBase {
    private double backLeft, backRight, frontLeft, frontRight = 0;

    private DcMotor back_Right, back_Left, front_Right, front_Left;

    public Drivetrain(HardwareMap hardwareMap) {
        back_Right = hardwareMap.get(DcMotor.class, "back_Right");
        front_Right = hardwareMap.get(DcMotor.class, "front_Right");
        front_Left = hardwareMap.get(DcMotor.class, "front_Left");
        back_Left = hardwareMap.get(DcMotor.class, "back_Left");

        back_Right.setDirection(DcMotorSimple.Direction.REVERSE);
        front_Right.setDirection(DcMotorSimple.Direction.REVERSE);

        front_Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        back_Left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_Left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_Right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_Right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //TODO: build runtoposition support in

    public void setPower(double BR, double BL, double FR, double FL) {
        backRight = BR;
        backLeft = BL;
        frontRight = FR;
        frontLeft = FL;
    }

    public void drive(double power) {
        backRight = power;
        backLeft = power;
        frontRight = power;
        frontLeft = power;
    }

    public void strafe(double power) {
        backRight = -power;
        backLeft = power;
        frontRight = power;
        frontLeft = -power;
    }

    public void driveNStrafe(double drivePower, double strafePower) {
        backRight = drivePower - strafePower;
        backLeft = drivePower + strafePower;
        frontRight = drivePower + strafePower;
        frontLeft = drivePower - strafePower;
    }

    @Override
    public void periodic() {
        back_Right.setPower(backRight);
        back_Left.setPower(backLeft);
        front_Right.setPower(frontRight);
        front_Left.setPower(frontLeft);
    }
}
