package press.turngeek.mymemo.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;

import javax.faces.event.ActionEvent;

import press.turngeek.mymemo.model.Memo;
import press.turngeek.mymemo.service.MemoServiceBean;

@SessionScoped
@ManagedBean(name = "memoController")
public class MemoController {

    private Memo            memo;

    @EJB
    private MemoServiceBean memoService;

    public MemoController() {
        memo = new Memo();
    }

    public Memo getMemo() {
        return memo;
    }

    public void setMemo(Memo memo) {
        this.memo = memo;
    }

    public void doAdd(ActionEvent event) {
        memoService.addMemo(memo);
        memo.setDescription("");
    }

    public void doReset(ActionEvent event) {
        memoService.resetMemos();
    }

    public List<Memo> getMemos() {
        return memoService.getAllMemos();
    }
}