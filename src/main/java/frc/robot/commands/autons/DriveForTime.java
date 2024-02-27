package frc.robot.commands.autons;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

import javax.print.DocFlavor.STRING;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveForTime extends Command {
    private DriveSubsystem m_drive;
    private double m_drivetime, m_xSpeed, m_ySpeed, m_rot;
    //private double m_startTime = 0;
    private Timer time = new Timer();
    private double currentTime = 0; 
    public DriveForTime(DriveSubsystem drive, double xSpeed, double ySpeed, double  rot, double drive_time){
        m_drive = drive;
        m_drivetime = drive_time;
        m_xSpeed = xSpeed;
        m_ySpeed = ySpeed;
        m_rot = rot;
        // 1 = intake cone, 2 = intake cube
        
        addRequirements(m_drive);
    }

    @Override
    public void initialize() {
        currentTime = Timer.getFPGATimestamp();
    }
    @Override
    public void execute(){
        m_drive.drive(m_xSpeed, m_ySpeed, m_rot, true, true);
    }
    @Override
    public boolean isFinished(){
        if(Timer.getFPGATimestamp() >= m_drivetime + currentTime)
        {
            SmartDashboard.putString("finished auto", Double.toString(time.get()));
            return true;
        }
        return false;
    }
    @Override
    public void end(boolean isInterrupted) {
        m_drive.drive(0, 0, 0, true, false);
        time.reset();
        time.stop();
    }
}