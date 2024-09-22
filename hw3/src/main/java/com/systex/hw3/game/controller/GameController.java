package com.systex.hw3.game.controller;

import java.io.IOException;
import com.systex.hw3.game.service.GuessGame;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		initializeGame(request);
		request.getRequestDispatcher("/game/guess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		GuessGame game = getGameFromSession(request);
		if (game == null) {
			initializeGame(request);
			game = getGameFromSession(request);
		}

		try {
			String guessedNumber = request.getParameter("guess");
			boolean isCorrect = game.guess(Integer.parseInt(guessedNumber));

			if (isCorrect) {
				request.getRequestDispatcher("/game/youWin.jsp").forward(request, response);
			} else {
				if (game.getRemains() == 0) {
					request.getRequestDispatcher("/game/youLose.jsp").forward(request, response);
				} else {
					request.setAttribute("errorMsg", "Wrong!");
					request.getRequestDispatcher("/game/guess.jsp").forward(request, response);
				}
			}
		} catch (NumberFormatException e) {
			// 處理非數字輸入
			request.setAttribute("errorMsg", "請輸入有效的數字!");
			request.getRequestDispatcher("game/guess.jsp").forward(request, response);
		}
	}

	private void initializeGame(HttpServletRequest request) {
		GuessGame game = new GuessGame(10, 3);
		request.getSession().setAttribute("game", game);
	}

	private GuessGame getGameFromSession(HttpServletRequest request) {
		return (GuessGame) request.getSession().getAttribute("game");
	}
}
