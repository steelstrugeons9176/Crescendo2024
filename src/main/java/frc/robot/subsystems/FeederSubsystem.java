package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederSubsystem extends SubsystemBase {
    private final CANSparkMax m_feeder = new CANSparkMax (2, MotorType.kBrushless);
    public FeederSubsystem () {
        m_feeder.setInverted(true);
        m_feeder.setIdleMode(IdleMode.kBrake);
        m_feeder.setSmartCurrentLimit(40);

    }
    public void runFeeder (double speed) {
        m_feeder.set(speed);
    }
}
