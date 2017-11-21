package bao.demos;

import bao.action.handlers.ComputeResultAction;
import bao.menu.BaseMenu;

public class ComputeOut01Action extends ComputeResultAction {
    public ComputeOut01Action(){
        super("%s !!!(我只输出 第一个空格前的字符)");
    }

    @Override
    public void preInput(BaseMenu list) {
        System.out.print("输入你的sql:\t");
    }
}
