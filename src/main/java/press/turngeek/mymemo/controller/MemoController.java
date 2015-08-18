package press.turngeek.mymemo.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import javax.faces.event.ActionEvent;

import press.turngeek.mymemo.model.Memo;
import press.turngeek.mymemo.service.MemoServiceBean;

@ViewScoped
@Named
public class MemoController implements Serializable {

    private static final long serialVersionUID = 8994022512914167890L;

    private Memo              memo;

    @Inject
    private MemoServiceBean   memoService;

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