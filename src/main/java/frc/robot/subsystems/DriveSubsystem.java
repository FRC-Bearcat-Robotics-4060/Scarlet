// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;
import frc.robot.commands.JoystickDriveCommand;


public class DriveSubsystem extends SubsystemBase {

  //Define Motors and put them into a single 'Drive', no clue why I have to switch out TalonSRX with WPI_TalonSRX, but it works.

  static WPI_TalonSRX _leftDrive = new WPI_TalonSRX(Constants.leftDriveTalonID);

  static WPI_TalonSRX _rightDrive = new WPI_TalonSRX(Constants.rightDriveTalonID);

  static DifferentialDrive m_drive = new DifferentialDrive(_leftDrive, _rightDrive);
  
  public DriveSubsystem() {
    // setDefaultCommand(new JoystickDriveCommand(null));
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("Drive encoder value", _l);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    //When Called, this directly sets the motor speed.
    _leftDrive.set(ControlMode.PercentOutput, leftSpeed);
    _rightDrive.set(ControlMode.PercentOutput, rightSpeed);
}

  public static void setDrivetrain(double forward, double rotate, boolean sqaureInput) {
    //When called, this calls the Drivetrain object and tells it the current request of forward and rotate, based on two axis, and the option to square those inputs.
    m_drive.arcadeDrive(forward, rotate, sqaureInput);
  }

}
