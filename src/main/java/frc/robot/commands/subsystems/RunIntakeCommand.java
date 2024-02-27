package frc.robot.commands.subsystems;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntakeCommand extends Command {
    private IntakeSubsystem m_intake;
 
    //private double m_startTime = 0;
    public RunIntakeCommand(IntakeSubsystem intake){
        m_intake = intake;
        // 1 = intake cone, 2 = intake cube
        
        addRequirements(m_intake);
    }
    @Override
    public void execute(){
        m_intake.runIntake(1);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
    @Override
    public void end(boolean isInterrupted) {
        m_intake.runIntake(0);
      
    }
}