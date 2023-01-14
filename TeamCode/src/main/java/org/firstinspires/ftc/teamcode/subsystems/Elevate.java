package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevate extends SubsystemBase {
    private Motor elevate_Left, elevate_Right;
    private MotorGroup elevateMotors;
    private int targetPosition = 220;
    private boolean isPowerMode = false;
    private double power = 1;

    public Elevate(HardwareMap hardwareMap) {
        elevate_Left = new Motor(hardwareMap, "elevate_Left", Motor.GoBILDA.RPM_312);
        elevate_Right = new Motor(hardwareMap, "elevate_Right", Motor.GoBILDA.RPM_312);

        elevateMotors = new MotorGroup(elevate_Left, elevate_Right);

        elevateMotors.resetEncoder();
        elevateMotors.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        elevateMotors.setRunMode(Motor.RunMode.PositionControl);
        elevateMotors.setPositionCoefficient(.05); //TODO: tune the value
        elevateMotors.setPositionTolerance(15); //TODO: tune the values
    }

    public void setPosition(int position) {
        targetPosition = position;
    }

    public void reset() {
        elevateMotors.resetEncoder();
    }

    public void setPowerModeOn() {
        elevateMotors.setRunMode(Motor.RunMode.RawPower);
        isPowerMode = true;
    }

    public void setPowerModeOff() {
        elevateMotors.setRunMode(Motor.RunMode.PositionControl);
        isPowerMode = false;
    }

    @Override
    public void periodic() {
        if (isPowerMode) {
            elevateMotors.set(power);
        } else {
            elevateMotors.setTargetPosition(targetPosition);
            elevateMotors.set(power);
        }
    }
}
