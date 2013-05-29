package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Action for enable animations in the application
 * @author Kristian
 */
public class DisableAnimationAction extends AbstractAction {

    private AnimationEngine engine;
    
    public DisableAnimationAction(AnimationEngine dayCardEngine) {
        super("Disable animation");
        engine = dayCardEngine;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        engine.setShowAnimation();
    }
}
