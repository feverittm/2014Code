/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 997robotics4
 *
 * Class: subcompressor Simple class to control the compressor on the robot.
 * Starting to develop extra methods/variables to control the duty cycle of the
 * compressor in order to prevent the compressor from overheating.
 */
public class subcompressor extends Subsystem {

    private Compressor myCompressor;
    private Timer myTimer;
    private TimerTask onTask = new TimerTask() {
        public void run() {
            startCompressor();
        }

    };
    private TimerTask offTask = new TimerTask() {

        public void run() {
            stopCompressor();
        }
    };

    private boolean isOn;

    /**
     *
     * @param compressorSwitchSlot digital port for pneumatics pressure switch
     * @param compressorSpikeSlot relay/spike port for compressor power
     */
    public subcompressor(int compressorSwitchSlot, int compressorSpikeSlot) {
        myCompressor = new Compressor(compressorSwitchSlot, compressorSpikeSlot);
        LiveWindow.addActuator("compressor", "compressor", myCompressor);
        myCompressor.start();
    }

    /**
     * Default command is to start the compressor. Doing it this way instead of
     * in the initializer will put it in a separate thread and not lock the main
     * control thread.
     */
    public void initDefaultCommand() {
    }

    /**
     * Start the compressor thread
     */
    public void startCompressor() {
        myCompressor.start();
        isOn = true;
    }

    /**
     * Stop the running compressor thread
     */
    public void stopCompressor() {
        myCompressor.stop();
        isOn = false;
    }

    /**
     *
     * @return true if the compressor has reached the preset pressure.
     */
    public boolean atPressure() {
        return myCompressor.getPressureSwitchValue();
    }

    /**
     * Utility function to put information on the SmartDashboard
     */
    public void SmartDashboard() {
        SmartDashboard.putData("Compressor", this);
        SmartDashboard.putBoolean("compressor is on", isOn);
        SmartDashboard.putBoolean("compressor is at pressure? ", atPressure());
    }
}
