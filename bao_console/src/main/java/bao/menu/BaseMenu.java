package bao.menu;


import bao.action.base.Worker;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * List
 */
@Slf4j
@Getter
@Setter
public abstract class BaseMenu {
    private String id;
    private String title;
    private String notice;
    private Worker worker;
    public BaseMenu(String id, String title){
        this(id, title, null, null);
    }
    public BaseMenu(String id, String title, String notice){
        this(id, title, notice, null);
    }
    public BaseMenu(String id, String title, String notice, Worker worker){
        this.id = id;
        this.title = title;
        this.notice = notice;
        this.worker = worker;
    }
    public void run() {
        if(this.getWorker()!=null)
            this.getWorker().work(this);
        else
            log.warn("No worker to running...");
    }
}
