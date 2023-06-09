//tasksテーブルのDTO（tasksデーブルのデータを覚えておくためのクラス）

package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity

@NamedQueries({
        //queryの内容に getAllTasks という名前を付ける
        //SELECT m = SELECT * であり、JPQLは通常のSQLと記述が異なる
        @NamedQuery(name = "getAllTasks", query = "SELECT m FROM Tasks AS m ORDER BY m.id DESC"),
        @NamedQuery(name = "getTasksCount", query = "SELECT COUNT(m) FROM Tasks AS m")
})

@Table(name = "tasks")
public class Tasks {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主キー値は自動採番する
    private Integer id;

    //タスクの内容
    @Column(name = "content", length = 255, nullable = false)
    private String content;

    //作成日時
    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    //更新日時
    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    //ここからフィールドのgetter/setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}