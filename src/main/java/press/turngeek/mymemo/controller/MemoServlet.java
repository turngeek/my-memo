package press.turngeek.mymemo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import press.turngeek.mymemo.model.Memo;

@WebServlet({"/MemoServlet", "/memos"})
public class MemoServlet extends HttpServlet {

    private static final long serialVersionUID = -7843898075264520941L;
    private ServletConfig     config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // no action
        sendResponse(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // get post parameter
        final String button = request.getParameter("button");
        switch (button) {
            case "reset":
                actionReset(request);
                sendResponse(request, response);
                break;
            case "save":
                String memoDescr = request.getParameter("memo");
                actionAddMemo(request, memoDescr);
                sendResponse(request, response);
                break;
            default:
                // no action
                sendResponse(request, response);
        }
    }

    private synchronized void actionReset(HttpServletRequest request) {
        List<Memo> memos = getMemos(request);
        memos.clear();
    }

    private synchronized void actionAddMemo(HttpServletRequest request, String memoDescr) {

        if (memoDescr != null && !memoDescr.isEmpty()) {
            List<Memo> memos = getMemos(request);
            // create memo
            Memo memo = new Memo();
            memo.setDescription(memoDescr);
            memo.setCreated(new Date());
            // add todo list
            memos.add(memo);
        } else {
            //set error message in request
            request.setAttribute("err", "Please, enter a memo!");
        }
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        config.getServletContext().getRequestDispatcher("/WEB-INF/memos.jsp").forward(request, response);
    }

    private List<Memo> getMemos(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Memo> memos = (List<Memo>)session.getAttribute("memos");
        if (memos == null) {
            memos = new LinkedList<Memo>();
            session.setAttribute("memos", memos);
        }
        return memos;
    }
}
