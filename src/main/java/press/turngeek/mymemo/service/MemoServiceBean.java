package press.turngeek.mymemo.service;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;


import press.turngeek.mymemo.model.Memo;
import press.turngeek.mymemo.data.MemoStore;

@RequestScoped
@Transactional(value=Transactional.TxType.REQUIRED)
public class MemoServiceBean {

    @Inject
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