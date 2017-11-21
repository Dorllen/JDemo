package bao.action.handlers;


import bao.action.base.AbstractHandlerAction;
import bao.action.base.AbstractInputAction;
import bao.action.preHandler.StringInputAction;
import bao.menu.BaseMenu;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class ComputeResultAction extends StringInputAction {
    private String rule;
    public ComputeResultAction(){
        rule = "";
    }
    public ComputeResultAction(String rule){
        this.rule = rule;
    }


    @Override
    public void doing(BaseMenu list, String inputValue) {
        // 做事情 ， 处理输入
        String[] chars = inputValue.split(" ");
        String values = String.format(rule, chars);
        System.out.println(values);
    }


}
