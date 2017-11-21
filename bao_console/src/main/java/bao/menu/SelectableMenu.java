package bao.menu;

import bao.action.base.Worker;
import lombok.Getter;
import lombok.Setter;

/**
 * 列表类型：选择列表
 */
@Getter
@Setter
public class SelectableMenu extends BaseMenu {
    private BaseMenu[] subList;
    public SelectableMenu(){this(null,null, null);}
    public SelectableMenu(String id, String title){
        this(id, title, null);
    }
    public SelectableMenu(String id, String title, String notice){
        this(id, title,notice,null);
    }
    public SelectableMenu(String id, String title, String notice, BaseMenu... list){
        this(id, title, null,null, list);
    }
    public SelectableMenu(String id, String title, Worker worker, BaseMenu... list){
        this(id, title, null, worker, list);
    }
    public SelectableMenu(String id, String title, String notice, Worker worker, BaseMenu... list){
        super(id, title, notice, worker);// 显示标题
        this.subList = list;
    }

    public int size(){
        return subList==null?0: subList.length;
    }
    public BaseMenu[] getSubList() {
        return subList;
    }
}
