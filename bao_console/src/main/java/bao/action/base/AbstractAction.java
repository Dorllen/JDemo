package bao.action.base;

import bao.menu.BaseMenu;

public abstract class AbstractAction implements Worker {

    @Override
    public void work(BaseMenu list) {
        // 处理流程，包括  输入前处理，输入后处理，任务处理
        preInput(list);
        afterInput(list,null);
        doing(list,null);
        after();
    }
    /**
     * 控制台第一次输入前
     * @param list
     */
    public abstract void preInput(BaseMenu list);

    /**
     * 控制台每次输入后
     * @param list
     * @param inputValue
     */
    public abstract void afterInput(BaseMenu list, String inputValue);

    public abstract void doing(BaseMenu list, String inputValue);

    public abstract int after();

}
