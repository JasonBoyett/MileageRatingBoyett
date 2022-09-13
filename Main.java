/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */

import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main{
    protected enum RATING {
        Poor, Fair, Good, Excelent, Error
    }
    

    public static void main(String[] args) throws NumberFormatException, HeadlessException, Exception {
        ImageIcon unscaledCar   = new ImageIcon("car.png");
        Image toScaler = unscaledCar.getImage();
        Image scaler = toScaler.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledCar = new ImageIcon(scaler);
         String carName = String.valueOf(JOptionPane.showInputDialog(null, "what kind of car do you have?", null, JOptionPane.INFORMATION_MESSAGE, scaledCar, null, ""));
        
        try {
            RATING rating = getRATING(Double.parseDouble(String.valueOf(JOptionPane.showInputDialog(null, "What is your car's MPG?", null, JOptionPane.INFORMATION_MESSAGE, scaledCar, null, ""))));
            if (rating == RATING.Error) {
                JOptionPane.showMessageDialog(null, "something went wrong.", "error", JOptionPane.ERROR_MESSAGE);
            } else if (rating == RATING.Excelent) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has excelent gass milage", "Excelent",
                        JOptionPane.INFORMATION_MESSAGE,  scaledCar);
            } else if (rating == RATING.Poor) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has poor gass milage", "Poor",
                        JOptionPane.INFORMATION_MESSAGE,  scaledCar);
            } else if (rating == RATING.Fair) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has fair gass milage", "Fair",
                        JOptionPane.INFORMATION_MESSAGE, scaledCar);
            } else if (rating == RATING.Good) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has good gass milage", "Good",
                        JOptionPane.INFORMATION_MESSAGE,  scaledCar);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "something went wrong.", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void setIconImage(ImageIcon scaledCar) {
    }

    public static RATING getRATING(double mpg){
        try{
            if(mpg < 20){
                return RATING.Poor;
            }
            else if(mpg >= 20 && mpg < 30){
                return RATING.Fair;
            }
            else if(mpg >= 30 && mpg < 40){
                return RATING.Good;
            }
            else if(mpg >= 40){
                return RATING.Excelent;
            }
        }
        catch(Exception e){
            return RATING.Error;
        }
        return RATING.Error;
    }
}