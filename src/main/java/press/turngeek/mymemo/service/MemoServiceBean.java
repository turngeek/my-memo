package press.turngeek.mymemo.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import press.turngeek.mymemo.model.Memo;
import press.turngeek.mymemo.data.MemoStore;

@Stateless
public class MemoServiceBean {

    @EJB
    private MemoStore memoStore;

    public List<Memo> getAllMemos() {
        List<Memo> memos = memoStore.findAll();
        return memos;
    }

    public void addMemo(Memo memo) {
        Memo newMemo = new Memo();
        newMemo.setDescription(memo.getDescription());
        newMemo.setCreated(new Date());
        memoStore.persist(newMemo);
    }

    public void resetMemos() {
        memoStore.removeAll();
    }
}