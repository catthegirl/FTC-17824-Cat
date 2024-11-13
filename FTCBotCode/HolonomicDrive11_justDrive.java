package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.hardware.hardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

@TeleOp(name = "HolonomicDrive11 (Blocks to Java)")
public class HolonomicDrive11_justDrive extends LinearOpMode {

  private DcMotor frontRight;
  private DcMotor backRight;
  private DcMotor frontLeft;
  private DcMotor backLeft;
  private ServoController ControlHub_ServoController;
  private Servo servo;

  public void runOpMode() {
    float horizontal;
    float vertical;
    float pivot;
    float armDown;
    float armUp;

    frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    backRight = hardwareMap.get(DcMotor.class, "backRight");
    frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
    backLeft = hardwareMap.get(DcMotor.class, "backLeft");
    ControlHub_ServoController = hardwareMap.get(ServoController.class, "Control Hub");
    servo = hardwareMap.get(Servo.class, "servo");

    // Put initialization blocks here.
    telemetry.addData("kkey", 1234);
    telemetry.update();
    frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      telemetry.addData("key", 321);
      telemetry.update();
      while (opModeIsActive()) {
        // Put run blocks here.
        horizontal = gamepad1.right_stick_x;
        vertical = gamepad1.right_stick_y;
        pivot = -gamepad1.left_stick_x;
        frontRight.setPower(-pivot + (vertical - horizontal));
        backRight.setPower(-pivot + vertical + horizontal);
        frontLeft.setPower(pivot + vertical + horizontal);
        backLeft.setPower(pivot + (vertical - horizontal));
        telemetry.addData("key", 123);
        
        if(gamepad1.a){
          servo.setPosition(1);
        }
        else if(gamepad1.b){
          servo.setPosition(0);
        }
      }
    }
  }
}
