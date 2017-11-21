package bao.action.preHandler;

import bao.menu.BaseMenu;
import bao.menu.SelectableMenu;
import bao.model.AppMenu;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectedDigitalAction extends DigitalInputAction {
    // 可以思考： 对每一个menu设置异常处理，或者对 SelectedAction 设置默认异常处理
    @Override
    public void doing(BaseMenu list, String inputValue) {
        if(list instanceof SelectableMenu) {
            SelectableMenu l = (SelectableMenu) list;
//            printList(l);
//            System.out.print(String.format("请输入你的选择0-%d：\t", l.size() - 1));
            BaseMenu base = getSubList(l, Integer.valueOf(inputValue)- ((AppMenu.returnCode + 1)));
            if (l.size() > 0 && Integer.valueOf(inputValue) - ((AppMenu.returnCode + 1)) < l.size()) {
                base.run();
            } else if((Integer.valueOf(inputValue) - (AppMenu.returnCode + 1)) >= l.size()){
                // 超出范围应当如何做..
                System.out.println("IllegalInputException");
            } else{
//                无下级列表如何做
                System.out.println("无下级列表..结束..");
            }
        } else{
            log.error("不符合规范!!!");
        }
    }

    public static BaseMenu getSubList(SelectableMenu l, int index){
        if(index>=0&&index<l.size()){
            BaseMenu tL = l.getSubList()[index];
            return tL;
        }else{
            return null;
        }
    }

    public static void printListWithOrder(String format, BaseMenu list){
        if(list instanceof SelectableMenu) {
            SelectableMenu l = (SelectableMenu)list;
            if (l != null && l.getSubList() != null) {
                for (int i =0; i < l.size(); i++) {
                    // 控制台输出选择
                    BaseMenu t = l.getSubList()[i];
                    System.out.println(String.format(format, i + AppMenu.returnCode + 1, t.getTitle()));
                }
            }
        }
    }

    public static void printList(String format, BaseMenu list){
        if(list instanceof SelectableMenu) {
            SelectableMenu l = (SelectableMenu)list;
            if (l != null && l.getSubList() != null) {
                for (int i =0; i < l.size(); i++) {
                    // 控制台输出选择
                    BaseMenu t = l.getSubList()[i];
                    System.out.println(String.format(format, t.getTitle()));
                }
            }
        }
    }

    public static void printList(BaseMenu list){
        printList("\t[%d]. %s", list);
    }

    public static void printListWithOrder(BaseMenu list){
        printListWithOrder("\t[%d]. %s", list);
    }

    @Override
    public void preInput(BaseMenu list) {
        System.out.print("\n======列表=====\n");
        printListWithOrder(list);
        System.out.print(String.format("请选择序号%s：\t", AppMenu.notify));
    }
}
