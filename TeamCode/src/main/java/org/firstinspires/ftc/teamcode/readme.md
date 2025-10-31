All code should use [FTCLib](https://docs.ftclib.org/ftclib/).

# OpModes

## Example OpModes

- Brody's FIRST OpMode
- Nick's FIRST OpMode

These OpModes were created for learning purposes and are not intended for use in competition.

## Normal OpModes

- PrimaryOpMode
  - Used for normal driving
  - Contains all features
- BackupOpMode
  - Used for driving if there are issues with the primary
  - Only drive and basic subsystem actions

# Subsystems

## Drivetrain

Subsystem for driving

### Commands

- UserDrive
  - Drives with controls from gamepad
  - Stops moving when done
  - Controls
    - Left Stick
      - Y: Forward
      - X: Strafe
    - Right Stick: X: Turn

## Shooter

Subsystem that runs launcher

### Commands

- RunShooter
  - Runs shooter motors and ramp motors in raw mode with the specified power

## Intake

Subsystem that runs intake

### Commands

- RunIntake
  - Runs intake motor in raw mode with the specified power