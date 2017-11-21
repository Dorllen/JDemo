package bao.action;

import bao.action.preHandler.DigitalInputAction;
import bao.action.preHandler.SelectedDigitalAction;
import bao.menu.BaseMenu;
import bao.menu.SelectableMenu;
import bao.model.AppMenu;

public class ApplicationAction extends DigitalInputAction {
    private SelectedDigitalAction chooseWork;
    public ApplicationAction(){
        chooseWork = new SelectedDigitalAction();
    }
    public ApplicationAction(SelectedDigitalAction worker){
        this.chooseWork = worker;
    }
    @Override
    public void doing(BaseMenu list, String inputValue) {
        if(list instanceof SelectableMenu) {
            chooseWork.work(((SelectableMenu) list).getSubList()[Integer.valueOf(inputValue) - (AppMenu.returnCode + 1)]);
        }
    }
    @Override
    public void preInput(BaseMenu list) {
        System.out.println(list.getTitle());
        if(list instanceof SelectableMenu) {
            SelectableMenu l =  (SelectableMenu)list;
            chooseWork.printListWithOrder(l);
            System.out.print(String.format("请选择序号%s：\t", AppMenu.notify));
        }
    }
}
