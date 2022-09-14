/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */

import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main{//memory hook

    protected enum RATING {//a set of enumerated values to represent the different ratings a car can have and an error
        Poor, Fair, Good, Excellent, Error
    }

    public static void main(String[] args) throws NumberFormatException, HeadlessException, Exception {//memory hook
        ImageIcon car = scaleImageIcon("car.png",100,100);//takes an image file and scales it to the desired size
        String carName = String.valueOf(JOptionPane.showInputDialog(null, "what kind of car do you have?", null, JOptionPane.INFORMATION_MESSAGE, car, null, ""));//a JOptionPane that gets the name of the users car
        
        try {//this try block outputs various JOptionPanes depending on the rating of the user's mpg value
            RATING rating = getRATING(Double.parseDouble(String.valueOf(JOptionPane.showInputDialog(null, "What is your car's MPG?", null, JOptionPane.INFORMATION_MESSAGE, car, null, ""))));//a JOptionPane that gets the user's mpg
            if (rating == RATING.Error) {//if the RATING comes back as an Error then an error message is displayed
                JOptionPane.showMessageDialog(null, "something went wrong.", "error", JOptionPane.ERROR_MESSAGE);
            } else if (rating == RATING.Excellent) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has excelent gas milage", "Excelent",JOptionPane.INFORMATION_MESSAGE, car);
            } else if (rating == RATING.Poor) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has poor gas milage", "Poor",JOptionPane.INFORMATION_MESSAGE, car);
            } else if (rating == RATING.Fair) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has fair gas milage", "Fair",JOptionPane.INFORMATION_MESSAGE, car);
            } else if (rating == RATING.Good) {
                JOptionPane.showMessageDialog(null, "your " + carName + " has good gas milage", "Good",JOptionPane.INFORMATION_MESSAGE, car);
            }
        } catch (NumberFormatException e) {//throws an exception if the user does not enter the value as a number
            JOptionPane.showMessageDialog(null, "something went wrong.", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static RATING getRATING(double mpg){//takes the user's mpg rating and gives it a rating that is then returned. If the mpg rating is 0 or less this method returns Error
        try{
            if(mpg > 0 && mpg < 20){
                return RATING.Poor;
            }
            else if(mpg >= 20 && mpg < 30){
                return RATING.Fair;
            }
            else if(mpg >= 30 && mpg < 40){
                return RATING.Good;
            }
            else if(mpg >= 40){
                return RATING.Excellent;
            }
            else if(mpg <= 0){
                return RATING.Error;
            }
        }
        catch(Exception e){//returns Error if anything goes wrong
            return RATING.Error;
        }
        return RATING.Error;
    }//end of getRATING method

    public static ImageIcon scaleImageIcon(String path, int width, int height){
        ImageIcon icon = new ImageIcon(path);//imports the image as an image icon
        Image image = icon.getImage();//casts the image as an Image object
        Image scaled = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);//scales the image
        icon.setImage(scaled);//recasts the scaled image as an ImageIcon
        return icon;//returns the scaled ImageIcon
    }
}//end of Main class