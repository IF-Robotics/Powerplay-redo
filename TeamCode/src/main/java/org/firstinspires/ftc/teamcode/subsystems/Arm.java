package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends SubsystemBase {
    private Motor arm;
    private Servo flip, wrist, wrist2, claw, tail;

    private double armPower = .5;
    private int armPostion = 20;

    private double flipPosition = .25;
    private double wristPosition = 1;
    private double clawPosition = .7;
    private double tailPosition = .53;

    public enum TailMode {
        Left, Right, Center
    }

    public Arm(HardwareMap hardwareMap) {
        arm = new Motor(hardwareMap, "arm", Motor.GoBILDA.RPM_435);
        arm.setRunMode(Motor.RunMode.PositionControl);
        arm.setPositionTolerance(10);

        flip = hardwareMap.get(Servo.class, "flip");
        wrist = hardwareMap.get(Servo.class, "wrist");
        wrist2 = hardwareMap.get(Servo.class, "wrist2");
        wrist2.setDirection(Servo.Direction.REVERSE);
        claw = hardwareMap.get(Servo.class, "claw");
        tail = hardwareMap.get(Servo.class, "tail");
    }

    public void setTailMode(TailMode tailMode) {
        if(tailMode == TailMode.Center) {
            tailPosition = .53;
        } else if (tailMode == TailMode.Left) {
            tailPosition = .3;
        } else {
            tailPosition = .65;
        }
    }

    //TODO: figure out if all these parameters are really needed (including flip & armPower)
    public void setArmPreset(double flip, double wrist, int arm, double armPower) {
        this.armPower = armPower;
        flipPosition = flip;
        wristPosition = wrist;
        armPostion = arm;
    }

    @Override
    public void periodic() {
        arm.set(armPower);
        arm.setTargetPosition(armPostion);

        flip.setPosition(flipPosition);
        wrist.setPosition(wristPosition);
        wrist2.setPosition(wristPosition);
        claw.setPosition(clawPosition);
        tail.setPosition(tailPosition);
    }
}
