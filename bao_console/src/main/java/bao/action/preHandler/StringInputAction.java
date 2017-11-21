package bao.action.preHandler;

import bao.action.base.AbstractInputAction;
import bao.menu.BaseMenu;
import bao.action.base.Worker;

public abstract class StringInputAction extends AbstractInputAction implements Worker {
    @Override
    public void afterInput(BaseMenu list, String inputValue){
        if ("exit".equals(inputValue)) {
            System.exit(0);
        }
    }

    @Override
    public int after() {
        return 0;
    }
}
