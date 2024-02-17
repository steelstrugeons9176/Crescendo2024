package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class RunShooterCommand extends Command {
    private ShooterSubsystem m_shooter;
 
    //private double m_startTime = 0;
    public RunShooterCommand(ShooterSubsystem shooter){
        m_shooter = shooter;
        // 1 = intake cone, 2 = intake cube
        
        addRequirements(m_shooter);
    }
    @Override
    public void execute(){
        m_shooter.runShooter(1);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
    @Override
    public void end(boolean isInterrupted) {
        m_shooter.runShooter(0);
      
    }
}