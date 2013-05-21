package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Action for turning of animations
 * @author Kristian
 */
public class EnableAnimationAction extends AbstractAction {

    public EnableAnimationAction(){
        super("Enable animation");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //AnimationEngine.setShowAnimation(true);
    }
    
}
