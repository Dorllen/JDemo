package bao.demos;

import bao.action.handlers.ResultHandlerAction;
import bao.menu.BaseMenu;

public class ResultHandler01Action extends ResultHandlerAction{
    // 调用另一个worker来做事情

    @Override
    public void doing(BaseMenu list, String inputValue) {
        System.out.println("我就是 查询学生 -> 学号查询 -> 学号 的输出结果: "+ inputValue + " (exit 退出)");
    }
}
