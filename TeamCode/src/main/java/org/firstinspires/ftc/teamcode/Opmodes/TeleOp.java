package org.firstinspires.ftc.teamcode.Opmodes;

import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot2;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {
    Robot robot = new Robot2(hardwareMap, false);

    @Override
    public void runOpMode() throws InterruptedException {
        while(opModeIsActive()) {
            
        }
    }
}
