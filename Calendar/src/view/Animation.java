package view;

/**
 * Abstract class that defines common characteristics of an animation
 * @author Kristian testing
 */


public abstract class Animation implements Drawable {   
    public boolean showAnimation;
  
    public void setShowAnimation(boolean show){
        showAnimation = show;
    }
}