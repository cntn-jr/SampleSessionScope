package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�t�H���[�h��
		String forwardPath = null;
		
		//�T�[�u���b�g�N���X�̓�������肷��uaction�v�̒l�����N�G�X�g�p�����[�^����擾
		String action = request.getParameter("action");
		
		//�u�o�^�J�n�v�����N�G�X�g���ꂽ�Ƃ��̏���
		if(action == null) {
			//�t�H���[�h�������
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}	
		//�o�^��ʂ���u�o�^���s�v�����N�G�X�g���ꂽ�Ƃ��̏���
		else if(action.equals("done")){
			//�Z�b�V�����X�R�[�v�ɕۑ����ꂽ�o�^���[�U���擾
			HttpSession session = request.getSession();
			User registerUser = (User) session.getAttribute("registerUser");
			//�o�^�����̌Ăяo��
			RegisterUserLogic logic=new RegisterUserLogic();
			logic.execute(registerUser);
			//�s�v�ƂȂ����Z�b�V�����X�R�[�v���̃C���X�^���X���폜
			session.getAttribute("registerUser");
			//�o�^��̃t�H���[�h���ݒ�
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}
		//�ݒ肳�ꂽ�t�H���[�h��Ƀt�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���N�G�X�g�p�����[�^�̎擾
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//�o�^���郆�[�U�̏���ݒ�
		User registerUser = new User(id,name,pass);
		
		//�Z�b�V�����X�R�[�v�ɓo�^���[�U��ۑ�
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		///�t�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
	}

}