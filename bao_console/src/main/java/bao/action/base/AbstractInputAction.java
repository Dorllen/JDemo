package bao.action.base;

import bao.model.AppMenu;

public abstract class AbstractInputAction extends AbstractComHandlerAction implements Worker {
    // 接受输入，传递输入

    @Override
    public int after() {
        return AppMenu.exitCode;
    }
}
