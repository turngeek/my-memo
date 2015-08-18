package press.turngeek.mymemo.data;

import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;

import javax.enterprise.context.SessionScoped;

import press.turngeek.mymemo.model.Memo;

@SessionScoped
public class MemoStore implements Serializable {

    private static final long serialVersionUID = -3258831452772896931L;

    private List<Memo>        memos;

    public MemoStore() {
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