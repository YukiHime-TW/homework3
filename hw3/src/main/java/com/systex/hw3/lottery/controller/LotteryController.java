package com.systex.hw3.lottery.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.systex.hw3.lottery.service.LotteryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LotteryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view;
		LinkedList<String> errorMsg = new LinkedList<>();
		request.setAttribute("errors", errorMsg);
		
		// Retrieve Form Data
		String groupCount = request.getParameter("groupCount");
		String excludeNumberString = request.getParameter("excludeNumber");
		ArrayList<Integer> excludeNumber = new ArrayList<>();

		// Validate Form Data
		if(groupCount == null || groupCount.trim().length() == 0) {
			errorMsg.add("必須輸入組數");
		} else {
			try {
				Integer.parseInt(groupCount);
			} catch (NumberFormatException e) {
				errorMsg.add("組數必須為數字");
			}
		}

		if (excludeNumberString == null || excludeNumberString.trim().length() == 0) {
			errorMsg.add("必須輸入不要的號碼");
		} else {
			String[] excludeNumberArray = excludeNumberString.split(" ");
			for (String num : excludeNumberArray) {
				try {
					int n = Integer.parseInt(num);
					if (n < 1 || n > 49) {
						errorMsg.add("不要的號碼必須介於1~49之間");
						break;
					}
				} catch (NumberFormatException e) {
					errorMsg.add("不要的號碼必須為數字");
					break;
				}
			}

		}
		
		if (!errorMsg.isEmpty()) {
			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
			return; // 把控制權還給Container
		}

		// Convert excludeNumberString to ArrayList<Integer>
		for (String num : excludeNumberString.split(" ")) {
			excludeNumber.add(Integer.parseInt(num));
		}
		
		try {
			String[] result = new LotteryService().getNumbers(Integer.parseInt(groupCount), excludeNumber);
			
			request.setAttribute("result", result);

			view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);

		}catch(Exception e){
			e.printStackTrace();
			errorMsg.add(e.getMessage());

			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
