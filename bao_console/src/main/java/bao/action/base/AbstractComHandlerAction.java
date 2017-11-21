package bao.action.base;

import bao.menu.BaseMenu;
import bao.action.base.AbstractAction;
import bao.menu.SelectableMenu;
import bao.model.AppMenu;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public abstract class AbstractComHandlerAction extends AbstractAction {
    // 通用的循环输入控制
    @Override
    public void work(BaseMenu list) {
        this.preInput(list);
        while (true) {
            Scanner in = new Scanner(System.in);
            String code = in.nextLine();
            try {
                this.afterInput(list, code);
                try{
                    this.doing(list, code);
                }finally {
                    if(after() == AppMenu.exitCode){
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                log.error("您的输入是：{},不符合条件", code);
            } catch (Exception e){
                log.error("处理过程异常...", e);
            }
        }
    }
}
