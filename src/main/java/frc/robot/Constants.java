package frc.robot;

import edu.wpi.first.wpilibj.geometry.Translation2d;
import frc.robot.util.PIDFGains;

/**
 * Constants
 */
public class Constants {

    public static final class Drivetrain {
        public static class SwerveModuleConstants {
            public static final double freeSpeedMetersPerSecond = 3.6576;
            public static final double driveRatio = 1.0 / 8.14; 
            public static final double steeringRatio = 1.0 / 12.8; 
            public static final double wheelRadiusMeters = 0.0508; // 2 inches (in meters)
            public static final double wheelCircumferenceMeters = wheelRadiusMeters * 2 * Math.PI; 
            public static final double driveDPRMeters = wheelCircumferenceMeters * driveRatio;
            
            public final Translation2d position;
            public final int idDrive;
            public final PIDFGains driveGains;
            public final int idSteering;
            public final PIDFGains steeringGains;

            public SwerveModuleConstants(Translation2d position, int idDrive, int idSteering) {
                this(position, idDrive, idSteering, new PIDFGains(1, 0, 0, 0, 0.1, 0), new PIDFGains(1, 0, 0, 0, 0.1, 0));
            }
            public SwerveModuleConstants(Translation2d position, int idDrive, int idSteering, PIDFGains driveGains, PIDFGains steeringGains) {
                this.position = position;
                this.idDrive = idDrive;
                this.driveGains = driveGains;
                this.idSteering = idSteering;
                this.steeringGains = steeringGains;
            }
        }
        public static final SwerveModuleConstants TLModule = new SwerveModuleConstants(new Translation2d(-0.215, 0.215), 1, 2);
        public static final SwerveModuleConstants TRModule = new SwerveModuleConstants(new Translation2d(0.215, 0.215), 3, 4);
        public static final SwerveModuleConstants BLModule = new SwerveModuleConstants(new Translation2d(-0.215, -0.215), 5, 6);
        public static final SwerveModuleConstants BRModule = new SwerveModuleConstants(new Translation2d(0.215, -0.215), 7, 8);
    }
    public static final class Joysticks {
        public static final double speedScalar = 0.7;
        public static final double deadband = 0.15;
        public static final int port = 0;
    }
}