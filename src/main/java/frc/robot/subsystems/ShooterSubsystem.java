package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class ShooterSubsystem extends SubsystemBase {
    private final CANSparkMax m_shootertop = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax m_shooterbottom = new CANSparkMax(4, MotorType.kBrushless);
    public ShooterSubsystem() {
        m_shootertop.setInverted(true);
        m_shootertop.setIdleMode(IdleMode.kBrake);
        m_shootertop.setSmartCurrentLimit(60);
        m_shooterbottom.setInverted(true);
        m_shooterbottom.setIdleMode(IdleMode.kBrake);
        m_shooterbottom.setSmartCurrentLimit(60);
    }
    public void runShooter (double speed) {
        m_shootertop.set(speed);
        m_shooterbottom.set(speed);
    }

}