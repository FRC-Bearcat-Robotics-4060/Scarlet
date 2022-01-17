// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {

  TalonSRX _leftDrive = new TalonSRX(Constants.leftDriveTalonID);

  TalonSRX _rightDrive = new TalonSRX(Constants.rightDriveTalonID);
  
  public DriveSubsystem() {}

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("Drive encoder value", _l);
    setMotors(0, 0.2);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    _leftDrive.set(ControlMode.PercentOutput, leftSpeed);
    _rightDrive.set(ControlMode.PercentOutput, rightSpeed);
}
}
