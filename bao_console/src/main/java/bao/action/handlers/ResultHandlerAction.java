package bao.action.handlers;

import bao.action.base.AbstractOutputAction;
import bao.menu.BaseMenu;
import bao.action.preHandler.SelectedDigitalAction;
import bao.action.preHandler.StringInputAction;

public class ResultHandlerAction extends StringInputAction {
    private String notice;
    private AbstractOutputAction worker;
    public ResultHandlerAction(){
        worker = new DefaultOutputHandler();
    }
    public ResultHandlerAction(String notice){
        this.worker = new DefaultOutputHandler();
        this.notice = notice;
    }
    public ResultHandlerAction(AbstractOutputAction worker){
        this(null, worker);
    }
    public ResultHandlerAction(String notice , AbstractOutputAction worker){
        this.notice = notice;
        this.worker = worker;
    }

    @Override
    public void doing(BaseMenu list, String inputValue) {
        worker.doing(list, inputValue);
    }

    @Override
    public void preInput(BaseMenu list) {
        if(notice!=null){
            System.out.print(notice+"\t");
        }
        // 输出下级title.
        SelectedDigitalAction.printList("%s", list);
        System.out.print("请输入：\t");
    }
}
