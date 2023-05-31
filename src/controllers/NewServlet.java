//新規登録処理(SQLでいうと、INSERT文)を行うコントローラ
package controllers;

import java.sql.Timestamp;
import javax.persistence.EntityManager;
import models.Tasks;
import utils.DBUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        //Tasksのインスタンスを作成
        Tasks m = new Tasks();

        //mの各フィールドにデータを代入
        //タスク内容
        String content = "test";
        m.setContent(content);

        //作成日時及び更新日時
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        m.setCreated_at(currentTime);
        m.setUpdated_at(currentTime);

        //データベースに保存
        em.persist(m);
        em.getTransaction().commit();

        //自動採番されたID値を表示
        response.getWriter().append(Integer.valueOf(m.getId()).toString());

        em.clear();
    }
}
