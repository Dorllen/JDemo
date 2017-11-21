package bao.util;

import bao.action.base.AbstractAction;
import bao.action.base.AbstractOutputAction;
import bao.action.base.Worker;
import bao.action.completion.CommLastAction;
import bao.action.ApplicationAction;
import bao.action.handlers.ComputeResultAction;
import bao.action.preHandler.DigitalInputAction;
import bao.action.preHandler.SelectedDigitalAction;
import bao.action.preHandler.StringInputAction;
import bao.action.handlers.DigitalHandlerAction;
import bao.action.handlers.ResultHandlerAction;
import bao.demos.ComputeOut01Action;
import bao.demos.ResultHandler01Action;
import bao.menu.BaseMenu;
import bao.menu.NoneMenu;
import bao.menu.SelectableMenu;
import bao.model.AppMenu;
import com.thoughtworks.xstream.XStream;

import java.io.*;

public class ConfigUtils {

    public static BaseMenu loadConfig(String filePath){
        AppMenu app = null;
        try {
            String xml = loadFile(filePath);
            try {
                XStream xStream = initXStream();
                app = (AppMenu) xStream.fromXML(xml);
                return init(app);
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return app;
    }

    public static AppMenu init(AppMenu app){
        // 当配置文件加载完后，需要动态的将配置文件的 String -> 对象，并初始化
        return app;
    }

    private static XStream initXStream() {
        XStream xStream = new XStream();
        // AppMenu's fields
        xStream.useAttributeFor("defaultTitle", String.class);// 指明xml文件的 属性  对象的是什么类型的
        xStream.useAttributeFor("title", String.class);
        xStream.useAttributeFor(BaseMenu.class, "title");
        xStream.useAttributeFor("id", String.class);
        xStream.useAttributeFor("notice", String.class);

        xStream.addImplicitCollection(SelectableMenu.class,"subList");// 指明 subList 字段将以 数组显示，如: <Item></Item><Item></Item>

        scannerPackages(xStream);
        return xStream;
    }

    private static void scannerPackages(XStream xStream) {
//        scannerPreHandlers(xStream);
//        scannerCompletions(xStream);

        ActionConvert.registerAction(Worker.class);//  这个转换是指，对BaseMenu的哪些属性进行转换
        ActionConvert.registerAction(AbstractAction.class);//  这个转换是指，对AppMenu的哪些属性进行转换

        // 所有要转换的Handler都需要注册
        ActionConvert.registerAction(ApplicationAction.class);
        ActionConvert.registerAction(SelectedDigitalAction.class);

        ActionConvert.registerAction(ResultHandlerAction.class);
        ActionConvert.registerAction(ResultHandler01Action.class);
        ActionConvert.registerAction(ComputeOut01Action.class);

        xStream.useAttributeFor(SelectableMenu.class, "worker");// 指明 字段 以属性格式显示
        xStream.aliasField("handler", SelectableMenu.class, "worker");//  指明字段 与 xml文件的映射关系，并且是SelectMenu的字段

        xStream.useAttributeFor(AppMenu.class, "worker");// 指明 字段 以属性格式显示
        xStream.aliasField("handler", AppMenu.class, "worker");//  指明字段 与 xml文件的映射关系，并且是SelectMenu的字段

        // 注册对handler的转换器
        xStream.registerConverter(ActionConvert.getInstance());


        scannerMenus(xStream);
    }

    private static void scannerMenus(XStream xStream) {
        xStream.alias("menus", AppMenu.class);// 定义xml中的别名 对应的类class
        xStream.alias("menu", BaseMenu.class);
        xStream.alias("menu", NoneMenu.class);
        xStream.alias("menu", SelectableMenu.class);
    }

    public static String loadFile(String filePath) throws IOException {
        StringBuffer sbf = new StringBuffer();
        BufferedReader br =  new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
        String s ;
        while((s = br.readLine()) != null){
            sbf.append(s);// BufferedReader 大小： 8192 * 2
        }
        return sbf.toString();
    }

    public static BaseMenu build(String filePath){
        AppMenu app = (AppMenu) initXStream().fromXML(new File(filePath));
        return app.init();
//        return ConfigUtils.loadConfig(filePath);
    }

    public static void main(String[] args) {
//        buildTest().run();
//        loadConfig();

//        buildTest().run();
        build("/Users/pengdongneng/projects/cashbus/cashbus/zdtest/src/main/java/bao/util/appTest.xml").run();

//        test();

    }

    private static void test() {
        if(true) {
//            System.out.println(ConfigUtils.class.getName());
            return;
        }

        XStream xStream = new XStream();
        xStream.useAttributeFor("defaultTitle", String.class);
        xStream.useAttributeFor("title", String.class);
        xStream.useAttributeFor("id", String.class);
        xStream.useAttributeFor("notice", String.class);
        xStream.useAttributeFor("defaultTitle", String.class);

        xStream.useAttributeFor(SelectableMenu.class, "worker");// 指明 字段 以属性格式显示
        xStream.aliasField("handler", SelectableMenu.class, "worker");//  指明字段 与 xml文件的映射关系，并且是SelectMenu的字段

//        xStream.useAttributeFor(AppMenus.class, "worker");

        xStream.alias("menus", AppMenu.class);
        xStream.alias("menu", BaseMenu.class);
        xStream.alias("menu", NoneMenu.class);
        xStream.alias("menu", SelectableMenu.class);

//        xStream.aliasField("handler", AppMenu.class, "worker");
//        xStream.aliasField("handler", NoneMenu.class, "worker");


        xStream.addImplicitArray(AppMenu.class, "menus");
        xStream.addImplicitCollection(SelectableMenu.class,"subList");
        ActionConvert.registerAction(DigitalInputAction.class);
        ActionConvert.registerAction(AbstractAction.class);
        ActionConvert.registerAction(Worker.class);//  这个转换是指，对AppMenu的哪些属性进行转换
        ActionConvert.registerAction(SelectedDigitalAction.class);//  这个转换是指，对AppMenu的哪些属性进行转换

        xStream.registerConverter(new ActionConvert());
//        AppMenu app = new AppMenu();
//        app.setMenus(new NoneMenu[]{new NoneMenu("query-id","query_id"),new NoneMenu("query-id", "query_id")});
//        app.setDefaultTitle("hhhh");
//        System.out.println(xStream.toXML(app));

        String code = "<menus defaultTitle=\"hhhh\">\n" +
                "  <menu>\n" +
                "    <id>query-id</id>\n" +
                "    <title>query_id</title>\n" +
                "  </menu>\n" +
                "  <menu>\n" +
                "    <id>query-id</id>\n" +
                "    <title>query_id</title>\n" +
                "  </menu>\n" +
                "</menus>";
        try {
            AppMenu ap = (AppMenu) xStream.fromXML(loadFile("/Users/pengdongneng/projects/cashbus/cashbus/zdtest/src/main/java/bao/util/app.xml"));
            System.out.println(ap.getDefaultPreHandler());
            System.out.println(ap.getTitle());
            System.out.println(ap.getNotice());
            System.out.println(ap.getWorker());
            BaseMenu[] baseMenus = ap.getSubList();
            System.out.println(baseMenus.length);
            System.out.println(baseMenus[0]);
            System.out.println(baseMenus[0].getTitle());
            System.out.println(baseMenus[0].getId());
            System.out.println(baseMenus[0].getWorker());

            System.out.println(((SelectableMenu)baseMenus[0]).getSubList().length);
            System.out.println(((SelectableMenu)baseMenus[0]).getSubList()[0]);
            System.out.println(((SelectableMenu)baseMenus[0]).getSubList()[0].getTitle());
            System.out.println(((SelectableMenu)baseMenus[0]).getSubList()[0].getWorker());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1. 输入一个值能做相应操作，如 计算、打印
     * 2. 输入一个值能返回上一步
     * 3. 输入一个值能结束所有操作
     * 4.
     *
     * @return
     */

    public static BaseMenu buildTest(){
        // app(启动，打印下级目录，并指明输入的处理器) -> app's select(只要输入字符，处理器会打印下级目录，等待输入，如果输入之后，选择下级，并调用下级目录处理器)
        //   -> 下级目录处理器

        SelectedDigitalAction selectedDigitalAction = new SelectedDigitalAction();// 选择行为
        CommLastAction endWorker = new CommLastAction();// 结束提醒行为
        ResultHandlerAction resultHandlerAction = new ResultHandlerAction();// 控制台输入行为

        ComputeResultAction computeOutAction = new ComputeResultAction("%s !!!"){

            @Override
            public void preInput(BaseMenu list) {
                System.out.print("输入你的sql:\t");
            }
        };// 规则计算行为


        ResultHandlerAction queryIdResultAction = new ResultHandlerAction(new AbstractOutputAction(){
            @Override
            public void doing(BaseMenu list, String inputValue) {
                // 此个是一直调用 doing ， 如果有输入的话
                System.out.println("你的输入是："+inputValue+", 已处理成功");
            }
        });
        SelectableMenu subOne = new SelectableMenu("query","查询学生", selectedDigitalAction, new SelectableMenu[]{
                new SelectableMenu("query-id","学号查询", selectedDigitalAction,
                        new SelectableMenu[]{new SelectableMenu("query-id-result","学号", queryIdResultAction)}),
                new SelectableMenu("query-name","姓名查询")});

        SelectableMenu subTwo = new SelectableMenu("update","更新信息", selectedDigitalAction,
                new SelectableMenu("update-id","学号", selectedDigitalAction,
                        new SelectableMenu[]{
                                new SelectableMenu("update-all","更新所有", resultHandlerAction, new NoneMenu("result-tip","", endWorker)),// 自身不处理，ResultShowWork 调用 下级列表 的work 去处理
                                new SelectableMenu("update-name","更新姓名"),
                                new SelectableMenu("update-sql","更新sql", computeOutAction)
                        }));

        ApplicationAction app = new ApplicationAction(selectedDigitalAction);// 首界面
        BaseMenu l = new SelectableMenu("application",">>>>>>>用户控制台<<<<<<", app, new SelectableMenu[]{subOne,subTwo});
        return l;
    }


    public static BaseMenu buildDemo1(){
        // app(启动，打印下级目录，并指明输入的处理器) -> app's select(只要输入字符，处理器会打印下级目录，等待输入，如果输入之后，选择下级，并调用下级目录处理器)
        //   -> 下级目录处理器

        SelectedDigitalAction selectedDigitalAction = new SelectedDigitalAction();// 选择行为
        CommLastAction endWorker = new CommLastAction();// 结束提醒行为
        ResultHandlerAction resultInputAction = new ResultHandlerAction();// 控制台输入行为

        DigitalHandlerAction computeRuleWorker = new DigitalHandlerAction("%s !!!");// 规则计算行为


        ResultHandlerAction queryIdResultAction = new ResultHandlerAction(new AbstractOutputAction(){
            @Override
            public void doing(BaseMenu list, String inputValue) {
                System.out.println("你的输入是："+inputValue+", 已处理成功");
            }
        });
        SelectableMenu subOne = new SelectableMenu("query","查询学生", selectedDigitalAction, new SelectableMenu[]{
                new SelectableMenu("query-id","学号查询", selectedDigitalAction,
                        new SelectableMenu[]{new SelectableMenu("query-id-result","学号", queryIdResultAction)}),
                new SelectableMenu("query-name","姓名查询")});

        SelectableMenu subTwo = new SelectableMenu("update","更新信息", selectedDigitalAction,
                new SelectableMenu("update-id","学号", selectedDigitalAction,
                        new SelectableMenu[]{
                                new SelectableMenu("update-all","更新所有", resultInputAction, new NoneMenu("result-tip","", endWorker)),// 自身不处理，ResultShowWork 调用 下级列表 的work 去处理
                                new SelectableMenu("update-name","更新姓名", new ResultHandlerAction() {
                                    @Override
                                    public void doing(BaseMenu list, String inputValue) {
                                        // 交给自身处理
                                        // 计算行为 15%3
                                        System.out.println("15%3="+inputValue);
                                    }
                                }),
                                new SelectableMenu("update-sql","更新sql", new StringInputAction(){
                                    @Override
                                    public void doing(BaseMenu list, String inputValue) {
                                        // 交给ComputeRuleWorker 去处理
                                        // 需输入 "22 5" -> 22 & 5 !!!
                                        computeRuleWorker.doing(list, inputValue);
                                    }

                                    @Override
                                    public void preInput(BaseMenu list) {
                                        SelectedDigitalAction.printListWithOrder(list);
                                        System.out.print("请输入你的sql：\t");
                                    }
                                })
                        }));

        ApplicationAction app = new ApplicationAction(selectedDigitalAction);// 首界面
        BaseMenu l = new SelectableMenu("application",">>>>>>>用户控制台<<<<<<", app, new SelectableMenu[]{subOne,subTwo});
        return l;
    }
}
