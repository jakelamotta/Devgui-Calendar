package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Action for turning of animations
 * @author Kristian
 */
public class EnableAnimationAction extends AbstractAction {

    private AnimationEngine animationengine;
    
    public EnableAnimationAction(AnimationEngine engine){
        super("Enable animation");
        this.animationengine = engine;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       animationengine.setShowAnimation();
    }
    
}
