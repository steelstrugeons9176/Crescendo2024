// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autons;

import frc.robot.commands.subsystems.ExampleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }
 public static Command oneNoteShot(OneNoteShot subsystem, DriveSubsystem m_robotDrive) throws InterruptedException {
    return Commands.sequence(new OneNoteShot(m_robotDrive));
  }
  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }

}
