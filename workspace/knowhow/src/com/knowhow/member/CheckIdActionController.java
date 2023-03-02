package com.knowhow.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.knowhow.Action;
import com.knowhow.Result;
import com.knowhow.member.dao.MemberDAO;

public class CheckIdActionController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		MemberDAO memberDAO = new MemberDAO();
		JSONObject json = new JSONObject();
		try {
			json.put("check", memberDAO.checkId(req.getParameter("memberIdentification")));
			out.print(json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		
		return null;
	}

}
