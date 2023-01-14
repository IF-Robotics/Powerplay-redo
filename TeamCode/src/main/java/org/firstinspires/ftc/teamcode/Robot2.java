package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Elevate;

public class Robot2 extends Robot {
    public Arm arm;
    public Drivetrain drivetrain;
    public Elevate elevate;

    private boolean isAuto;

    public Robot2(HardwareMap hardwareMap, boolean isAuto) {
        this.isAuto = isAuto;
        arm = new Arm(hardwareMap);
        drivetrain = new Drivetrain(hardwareMap);
        elevate = new Elevate(hardwareMap);
    }
}
