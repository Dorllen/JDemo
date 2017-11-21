package bao;

import bao.util.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * MainController
 */
@Slf4j
public class MainController {

    /**
     * 做法是：行为与对象分离。即列表单项和列表单项的行为分离
     * 思考：行为是可以修改的、传递的，只需要设置列表单项的行为，即达到 拓展
     * Worker 是 对象的行为
     *  -AbstractWorker 抽象构一层
     *  -ChooseWorker 定义用户选择行为
     *  -ComputeRuleWorker 定义输入结果处理器
     *  -ComputeWorker 计算行为
     *  -DefaultWorker 定义列表启动及之后的行为
     *  -NumberEndWorker 定义此次行为之后无 '选择行为'
     *  -NumberInputWorker 控制台输入的通用用户行为, 用于处理数字输入
     *  -StringInputWorker 控制台输入的通用用户行为, 用于处理字符串输入
     *
     */

    public static void main(String[] args) {

        ConfigUtils.build("/Users/pengdongneng/projects/cashbus/cashbus/zdtest/src/main/java/bao/util/appTest.xml").run();


//        ConfigUtils.buildTest().run();
//        BaseMenu l = MainController.buildDemo();
//        l.run();
    }

//    private static BaseMenu buildDemo() {
//        SelectedDigitalAction chooseWork = new SelectedDigitalAction();// 选择行为
//        ApplicationAction defaultWorker = new ApplicationAction(chooseWork);// 首列表行为
//        CommLastAction endWorker = new CommLastAction();// 放于下级列表处理
//        Worker resultShowWork = new ListDisplayAction(chooseWork);// 自身不处理，用下级列表自身去work
//
//        DigitalHandlerAction computeRuleWorker = new DigitalHandlerAction("%s & %s !!!");// 规则处理行为
//
//        SelectableMenu subOne = new SelectableMenu("","0.测试", chooseWork, new SelectableMenu[]{
//                new SelectableMenu("","0.二级0测试", chooseWork,
//                        new SelectableMenu[]{new SelectableMenu("","0.三级0测试"),new SelectableMenu("","1.三级1选择")}),
//                new SelectableMenu("","1.二级1测试")});
//        SelectableMenu subTwo = new SelectableMenu("","1.做题", chooseWork,
//                new SelectableMenu[]{
//                    new SelectableMenu("","0.初级", resultShowWork, new NoneMenu("","1+1", endWorker)),// 自身不处理，ResultShowWork 调用 下级列表 的work 去处理
//                    new SelectableMenu("","1.中级", new ListDisplayAction(chooseWork) {
//                            @Override
//                            public void doing(BaseMenu list, String inputValue) {
//                                // 交给自身处理
//                                // 计算行为 3*8
//                                System.out.println("You are right!!!");
//                            }
//                        }, null, new NoneMenu("","3*8")),
//                    new SelectableMenu("","2.高级", new ListDisplayAction(chooseWork) {
//                            @Override
//                            public void doing(BaseMenu list, String inputValue) {
//                                // 交给自身处理
//                                // 计算行为 15%3
//                                System.out.println("15%3="+inputValue);
//                            }
//                        }, new NoneMenu("","15%3")),
//                    new SelectableMenu("","3.不凡", new StringInputAction(){
//                            @Override
//                            public void doing(BaseMenu list, String inputValue) {
//                                // 交给ComputeRuleWorker 去处理
//                                // 需输入 "22 5" -> 22 & 5 !!!
//                                computeRuleWorker.doing(list, inputValue);
//                            }
//
//                            @Override
//                            public void before(BaseMenu list) {
//                                System.out.print("======列表=====\n");
//                                chooseWork.printList(list);
//                                System.out.print("请输入你的选择：\t");
//                            }
//                        }, new NoneMenu("","33%15+1"))
//        });
//
//        BaseMenu l = new SelectableMenu("","请选择类型：", defaultWorker, new SelectableMenu[]{subOne,subTwo});
//        return l;
//    }
}
