package com.servlet.teacher;

import com.impl.ScoreImpl;
import com.impl.StudentImpl;
import com.impl.SubjectImpl;
import com.impl.TeacherImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;
import com.entity.Operator;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teacher;

public class GetAvgServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // AJAX异步查询课程
        ScoreImpl scoreimpl = new ScoreImpl();
        TeacherImpl teacherImpl = new TeacherImpl();
        SubjectImpl subjectImpl = new SubjectImpl();
        Operator operator;
        Teacher teacher;
        List<Subject> list_subject = null;
        operator = (Operator) request.getSession().getAttribute("log_operator");
        int ope_rol_id = operator.getRole().getId();

        teacher = teacherImpl.query("ope_id", operator.getId() + "").get(0);
        list_subject = subjectImpl.query("tec_stu_all", teacher.getId()
                    + "");
        List<Integer> list = new ArrayList<>();
        for (Subject subject:list_subject) {
            list.add(scoreimpl.getAvg(subject.getId()));
        }
        System.out.println(list);
        response.getWriter().write(
                JSONSerializer.toJSON(list).toString());

    }
}
