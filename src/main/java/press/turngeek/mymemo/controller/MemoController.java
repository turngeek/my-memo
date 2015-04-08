package press.turngeek.mymemo.controller;

import java.util.Date;
import java.util.List;
import java.util.LinkedList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.event.ActionEvent;

import press.turngeek.mymemo.model.Memo;

@ViewScoped
@ManagedBean(name = "memoController")
public class MemoController {

    private Memo       memo;
    private List<Memo> memos;

    public MemoController() {
		memos=new LinkedList<>();
		memo=new Memo();
	}

    public Memo getMemo() {
        return memo;
    }

    public void setMemo(Memo memo) {
        this.memo = memo;
    }

    public void doSave(ActionEvent event) {
        Memo newMemo = new Memo();
        newMemo.setDescription(memo.getDescription());
        newMemo.setCreated(new Date());
        memos.add(newMemo);
        memo.setDescription("");
    }

    public void doReset(ActionEvent event) {
        memos.clear();
    }

    public List<Memo> getMemos() {
        return memos;
    }

}