package com.servlet.cla2sub;

import com.impl.ScoreImpl;
import com.impl.StudentImpl;
import com.impl.TeacherImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Operator;
import com.entity.Score;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.*;
import com.impl.Cla2SubImpl;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import net.sf.json.JSONSerializer;

import java.io.OutputStream;

public class Export_GradeServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            resp.setContentType("text/html");
            resp.setContentType("application/vnd.ms-excel");
            StudentImpl studentImpl = new StudentImpl();
            TeacherImpl teacherImpl = new TeacherImpl();
            ScoreImpl scoreImpl = new ScoreImpl();
            Operator operator;
            Student student;
            List<Score> list_score;
            operator = (Operator) req.getSession().getAttribute("log_operator");
            int ope_rol_id = operator.getRole().getId();

            String search_type = req.getParameter("search_type");
            //String search_value = java.net.URLDecoder.decode(req//.getParameter("value"), "UTF-8");
            //int page = Integer.parseInt(req.getParameter("page"));

            String stuname = operator.getName();
            String fileName = stuname + "成绩.xls";
            resp.setHeader("Content-Disposition", "attachment;" + " filename="
                    + new String(fileName.getBytes(), "ISO-8859-1"));
            OutputStream os = resp.getOutputStream();
            WritableWorkbook wwb = Workbook.createWorkbook(os);
            WritableSheet ws = wwb.createSheet(stuname + "成绩表", 0);
            WritableFont title_big = new WritableFont(WritableFont.ARIAL, 16,
                    WritableFont.BOLD);
            WritableFont title_little = new WritableFont(WritableFont.ARIAL,
                    12, WritableFont.BOLD);
            WritableCellFormat f1 = new WritableCellFormat(title_big);
            f1.setAlignment(Alignment.CENTRE);
            f1.setVerticalAlignment(VerticalAlignment.CENTRE);
            f1.setBorder(Border.ALL, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
            WritableCellFormat f2 = new WritableCellFormat(title_little);
            f2.setAlignment(Alignment.CENTRE);
            f2.setVerticalAlignment(VerticalAlignment.CENTRE);
            f2.setBorder(Border.ALL, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
            WritableCellFormat f3 = new WritableCellFormat();
            f3.setAlignment(Alignment.CENTRE);
            f3.setVerticalAlignment(VerticalAlignment.CENTRE);
            f3.setBorder(Border.ALL, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
//            ws.setRowView(0, 500);
//            ws.setRowView(1, 500);
//            ws.setRowView(2, 500);
//            ws.setRowView(3, 500);
//            ws.setRowView(4, 500);
//
//            ws.mergeCells(0, 0, 4, 0);
            Label label;
            list_score = new ArrayList<Score>();
//            label = new Label(0, 0, stuname + "成绩表  ", f1);
//            ws.addCell(label);

            String[] title = { "学号","科目",	"平时分","考试分","总分" };

            for (int i = 0; i < title.length; i++) {
                label = new Label(i, 1, title[i], f2);
                ws.addCell(label);
                ws.setColumnView(i, 15);
            }
            student = studentImpl.query("ope_id", operator.getId() + "").get(0);
            if (search_type.equals("stu_all")) {
                list_score = scoreImpl.query("stu_all", student.getId() + "");
            } else if (search_type.equals("sub_name")) {
                list_score = scoreImpl.query("stu_sub_name", student.getId()
                        + "_" );
            } else {
                list_score = scoreImpl.query("stu_tec_name", student.getId()
                        + "_");
            }
            for (int i = 0; i < list_score.size(); i++) {
                label = new Label(0, i + 2, list_score.get(i).getId().toString(),f3);
                ws.addCell(label);
                label = new Label(1, i + 2, list_score.get(i).getSubject()
                        .getName(), f3);
                ws.addCell(label);
                label = new Label(2, i + 2, list_score.get(i).getDaily()
                        .toString(), f3);
                ws.addCell(label);
                label = new Label(3, i + 2, list_score.get(i).getExam()
                        .toString(), f3);
                ws.addCell(label);
                label = new Label(4, i + 2, list_score.get(i).getCount()
                        .toString(), f3);
                ws.addCell(label);
                ws.setRowView(i + 2, 400);
            }
            wwb.write();
            wwb.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
