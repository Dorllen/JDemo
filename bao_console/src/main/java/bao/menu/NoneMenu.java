package bao.menu;

import bao.action.base.Worker;

/**
 * 列表类型：空列表，及无输出列表
 */
public class NoneMenu extends BaseMenu {
    public NoneMenu(String id, String title){
        this(id ,title,null);
    }
    public NoneMenu(String id, String title, Worker worker){
        super(id, title,null, worker);
    }
}
