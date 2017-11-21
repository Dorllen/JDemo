package bao.action.handlers;

import bao.action.base.AbstractOutputAction;
import bao.menu.BaseMenu;

public class DefaultOutputHandler extends AbstractOutputAction {
    // 默认处理行为 及 输出行为
    @Override
    public void doing(BaseMenu list, String inputValue) {
        System.out.println("我就是默认的最终结果输出(exit[字符串型输入] 或 -1[整型输入选择] 退出？)...您的输入："+inputValue);
    }
}
