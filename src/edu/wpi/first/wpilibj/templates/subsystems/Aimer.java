/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author 997robotics3
 */
public class Aimer extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private AxisCamera myCamera = AxisCamera.getInstance();
   private ColorImage myImage;
   private BinaryImage filteredImage;
   final int  RECTANGULARITY_LIMIT = 40;
   final int ASPECT_RATIO_LIMIT = 55;
   public class Scores {
        double rectangularity;
        double aspectRatioVertical;
        double aspectRatioHorizontal;
    }
   double scoreRectangularity(ParticleAnalysisReport report){
            if(report.boundingRectWidth*report.boundingRectHeight !=0){
                    return 100*report.particleArea/(report.boundingRectWidth*report.boundingRectHeight);
            } else {
                    return 0;
            }	
    }
   public double scoreAspectRatio(BinaryImage image, ParticleAnalysisReport report, int particleNumber, boolean vertical) throws NIVisionException
    {
        double rectLong, rectShort, aspectRatio, idealAspectRatio;

        rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        rectShort = NIVision.MeasureParticle(image.image, particleNumber, false, NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
        idealAspectRatio = vertical ? (4.0/32) : (23.5/4);	//Vertical reflector 4" wide x 32" tall, horizontal 23.5" wide x 4" tall
	
        //Divide width by height to measure aspect ratio
        if(report.boundingRectWidth > report.boundingRectHeight){
            //particle is wider than it is tall, divide long by short
            aspectRatio = ratioToScore((rectLong/rectShort)/idealAspectRatio);
        } else {
            //particle is taller than it is wide, divide short by long
            aspectRatio = ratioToScore((rectShort/rectLong)/idealAspectRatio);
        }
	return aspectRatio;
    }
   double ratioToScore(double ratio)
	{
		return (Math.max(0, Math.min(100*(1-Math.abs(1-ratio)), 100)));
        }
   boolean scoreCompare(Scores scores, boolean vertical){
	boolean isTarget = true;

	isTarget &= scores.rectangularity > RECTANGULARITY_LIMIT;
	if(vertical){
            isTarget &= scores.aspectRatioVertical > ASPECT_RATIO_LIMIT;
	} else {
            isTarget &= scores.aspectRatioHorizontal > ASPECT_RATIO_LIMIT;
	}

	return isTarget;
    }
   
   
   public boolean goalIsHot() {
        try {
            
            
            
            myImage = myCamera.getImage();
            filteredImage = myImage.thresholdRGB(233, 250, 198, 253, 71, 203);
            filteredImage.removeSmallObjects(true, 3);
             
             Scores scores[] = new Scores[filteredImage.getNumberParticles()];
                /// not creating the objects in array, just the array.
                ///creating a number of "scores" equal to the number objects in the binImage.
            int verticalTargetCount,horizontalTargetCount = 0;
            
            
          
            if (filteredImage.getNumberParticles()>0){
               for (int i = 0; i < 4 && i < filteredImage.getNumberParticles(); i++) {
                   ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                   scores[i] = new Scores();
                   
                   
                        scores[i].rectangularity = scoreRectangularity(report);
			scores[i].aspectRatioVertical = scoreAspectRatio(filteredImage, report, i, true);
			scores[i].aspectRatioHorizontal = scoreAspectRatio(filteredImage, report, i, false);
                        
                        if(scoreCompare(scores[i], false))
			{
                            return true;
			} 
                   }
            }
            
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return false;
                }
        public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

  
    }

