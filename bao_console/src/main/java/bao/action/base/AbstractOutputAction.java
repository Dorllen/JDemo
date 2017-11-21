package bao.action.base;

import bao.menu.BaseMenu;
import bao.model.AppMenu;

public abstract class AbstractOutputAction extends AbstractComHandlerAction implements Worker {
    // 处理任务，及输出
    @Override
    public void afterInput(BaseMenu list, String inputValue){
    }

    @Override
    public void preInput(BaseMenu list) {
    }

    @Override
    public int after() {
        return AppMenu.exitCode;
    }
}
