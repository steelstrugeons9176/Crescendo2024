package frc.robot.commands.autons;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
// import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants.AutonConstants;

public class OneNoteShot extends SequentialCommandGroup{
    public OneNoteShot(DriveSubsystem m_robotDrive, RobotContainer container) {

					Trajectory trajectory = createStraightForwardTrajectory(container);
                    addCommands(
						new InstantCommand(() -> m_robotDrive.resetOdometry(trajectory.getInitialPose())),
						
						new InstantCommand(() -> m_robotDrive.drive(0, 0, 0, false, false))
                       // new DriveForTime(m_robotDrive, 0.5, 0, 0,0.42),
                       // new WaitCommand(0.1),
                        // new DriveForTime(m_robotDrive, -1, 0, 0,.10)
                       // new WaitCommand(0.1),
                       // new DriveForTime(m_robotDrive, 0.5, 0, 0,0.42)
                        
                
                    
           );

        /**
         * If intake is South:
         * -x goes south
         * x goes north
         * -y goes west
         * y goes east
         * .42 ~ 1  meter identified at .5 speed (x)
         * .10 ~ 1  meter identified at 1.0 speed (x)
         */
        
    }
    public Trajectory createTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(new Translation2d(1, 1)),
			// End straight ahead of where we started, facing forward
			new Pose2d(Units.inchesToMeters(
                AutonConstants.DISTANCE_FROM_START_OF_SPEAKER_TO_STAGE + 
                AutonConstants.DISTANCE_FROM_SPEAKER_TO_OUTSIDE_COMMUNITY), 0, Rotation2d.fromDegrees(0)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

    public Trajectory createStraightForwardTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(),
			// End 2 meters straight ahead of where we started, facing forward
			new Pose2d(2, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}
public Trajectory createSCurveTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
			// End 3 meters straight ahead of where we started, facing forward
			new Pose2d(3, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}


    public Trajectory createStraightInReverseTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(/*new Translation2d(1, 1)*/),
			// End 2 meters straight ahead of where we started, facing back
			new Pose2d(2, 0, Rotation2d.fromDegrees(180.0)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}
}
