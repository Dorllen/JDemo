package bao.action.handlers;

import bao.action.preHandler.StringInputAction;
import bao.menu.BaseMenu;
import bao.menu.SelectableMenu;

public class DisplayMenuResultAction extends StringInputAction{

    @Override
    public void doing(BaseMenu list, String inputValue) {
        // 当前list
        if (list instanceof SelectableMenu) {
            BaseMenu[] baseMenus = ((SelectableMenu) list).getSubList();
            if (baseMenus != null && baseMenus.length > 0) {
                baseMenus[0].run();// 规定：用下级列表第一个
            }
        }
    }

    @Override
    public void preInput(BaseMenu list) {

    }
}
