package bao.action.completion;


import bao.action.base.AbstractLastAction;
import bao.menu.BaseMenu;

public class CommLastAction extends AbstractLastAction {
    @Override
    public void doing(BaseMenu list, String inputValue) {
        // 算到这里就结束了(下级列表取不到上级输入值的)
        System.out.println("算到这里就结束了(下级列表取不到上级输入值的).... ");
    }

    @Override
    public void preInput(BaseMenu list) {

    }

    @Override
    public void afterInput(BaseMenu list, String inputValue) {

    }

    @Override
    public int after() {
        return 0;
    }
}

