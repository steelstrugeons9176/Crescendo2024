package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final CANSparkMax m_intake = new CANSparkMax(2, MotorType.kBrushless);
    public IntakeSubsystem () {
        m_intake.setInverted(false);
        m_intake.setIdleMode(IdleMode.kBrake);
        m_intake.setSmartCurrentLimit(40);

    }
    public void runIntake (double speed) {
        m_intake.set(speed);
    }
}
