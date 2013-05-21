package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Action for enable animations in the application
 * @author Kristian
 */
public class DisableAnimationAction extends AbstractAction {

    public DisableAnimationAction(){
        super("Disable animation");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //AnimationEngine.setShowAnimation(false);
    }
}
