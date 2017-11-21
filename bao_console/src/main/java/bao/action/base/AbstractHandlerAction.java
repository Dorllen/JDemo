package bao.action.base;

import bao.menu.BaseMenu;
import bao.model.AppMenu;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public abstract class AbstractHandlerAction extends AbstractAction {
    // 用于传递处理 任务，不调用work
    @Override
    public void work(BaseMenu list) {

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
