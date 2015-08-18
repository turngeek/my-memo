package press.turngeek.mymemo.data;

import java.util.List;
import java.util.LinkedList;

import javax.ejb.Singleton;

import press.turngeek.mymemo.model.Memo;

@Singleton
public class MemoStore {

    private List<Memo> memos;

    public MemoStore() {
        super();
        memos = new LinkedList<Memo>();
    }

    public List<Memo> findAll() {
        return memos;
    }

    public void persist(Memo memo) {
        memos.add(memo);
    }

    public void removeAll() {
        memos.clear();
    }
}