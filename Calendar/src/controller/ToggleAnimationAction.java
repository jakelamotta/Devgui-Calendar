package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;

/**
 * Action for enable animations in the application
 * @author Kristian
 */
public class ToggleAnimationAction extends AbstractAction {

    private AnimationEngine engine;
    private boolean toggled;
    private final String description = "Toggle the weather animation on and off";
    
    public ToggleAnimationAction(AnimationEngine dayCardEngine) {
        super("Enable animation");
        engine = dayCardEngine;
        toggled = true;
        putValue(SHORT_DESCRIPTION, description);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        engine.setShowAnimation();
        
        //logical or to set toggled to true if false and false if true
        toggled = toggled != true;
        
        changeButtonText();
    }
    
    /**
     * Changes the text of the action depending on whether or not the
     * animation is enabled or not
     */
    public void changeButtonText(){
        if(toggled){
            putValue(NAME, "Enable animation");
        }
        else{
            putValue(NAME, "Disable animation");
        }
    }
}
