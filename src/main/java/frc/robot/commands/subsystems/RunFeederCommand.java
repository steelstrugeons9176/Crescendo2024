package frc.robot.commands.subsystems;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FeederSubsystem;

public class RunFeederCommand extends Command {
    private FeederSubsystem m_feeder;
    //private double m_startTime = 0;
    public RunFeederCommand(FeederSubsystem feeder){
        m_feeder = feeder;
        // 1 = intake cone, 2 = intake cube
        
        addRequirements(m_feeder);
    }
    @Override
    public void execute(){
        m_feeder.runFeeder(1);
    }
    @Override
    public boolean isFinished(){
        return false;
    }
    @Override
    public void end(boolean isInterrupted) {
        m_feeder.runFeeder(0);
      
    }
}