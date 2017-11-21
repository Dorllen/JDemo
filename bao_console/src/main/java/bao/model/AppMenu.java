package bao.model;

import bao.action.base.AbstractAction;
import bao.menu.SelectableMenu;
import lombok.Data;

@Data
public class AppMenu extends SelectableMenu {
    private String defaultTitle = "";// 定义 默认标题
    private AbstractAction entranceHandler;// 定义 程序入口处理器
    private AbstractAction defaultProcessHandler;// 定义 默认的过程处理器
    private AbstractAction defaultPreHandler;// 定义 默认的输入处理器
    private AbstractAction exceptionHandler;// 定义 默认的过程处理器
    private AbstractAction noWorkHandler;// 当没有下层work，之后的行为
    public AppMenu(){
        this(null, null);
    }
    public AppMenu(String id, String defaultTitle){
        super(id,defaultTitle);
    }

    public static int exitCode = -1;// 退出code
    public static int returnCode = 0;// 返回上一层code，returnCode > exitCode
    public static String notify = "";// 操作 提醒

    public AppMenu init(){
//        当配置文件加载完后，需要动态的将配置文件的 String -> 对象，并初始化
        return this;
    }
}
