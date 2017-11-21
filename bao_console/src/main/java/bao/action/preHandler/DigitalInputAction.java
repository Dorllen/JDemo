package bao.action.preHandler;

import bao.action.base.AbstractInputAction;
import bao.menu.BaseMenu;
import bao.action.base.Worker;

public abstract class DigitalInputAction extends AbstractInputAction implements Worker {

    @Override
    public void afterInput(BaseMenu list, String inputValue){
        int exit = Integer.valueOf(inputValue);
        if (exit == -1) {
            System.exit(0);
        }
    }
}
