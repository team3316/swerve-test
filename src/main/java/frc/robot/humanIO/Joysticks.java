package frc.robot.humanIO;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import frc.robot.Constants;

public class Joysticks {
    private Joystick joystick;

    public Joysticks() {
        joystick = new Joystick(Constants.Joysticks.port);
    }

    private static double calculateDeadband(double value) {
        return Math.abs(value) > Constants.Joysticks.deadband ? value : 0;
    }

    public double getY() {
        return calculateDeadband(joystick.getY());
    }
    public double getX() {
        return calculateDeadband(joystick.getX());
    }

    public SwerveModuleState getDesiredState() {
        double y = joystick.getX();
        double x = -joystick.getY();
        double speed = calculateDeadband(Math.hypot(x, y)) 
                                            * Constants.Drivetrain.SwerveModuleConstants.freeSpeedMetersPerSecond 
                                            * Constants.Joysticks.speedScalar;
        Rotation2d angle = new Rotation2d(x, y);
        if(y < 0) {
            angle = Rotation2d.fromDegrees(angle.getDegrees() + 360);
        }
        return new SwerveModuleState(speed,angle);
    }

    public boolean isTriggerPressed() {
        return joystick.getTriggerPressed();
    }

}
