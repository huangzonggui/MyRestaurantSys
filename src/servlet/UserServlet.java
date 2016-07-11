package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Userinfo;
import dao.UserinfoDao;
import dao.UserinfoDaoImpl;
import util.JsonUtil;
import util.Md5Utils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet.do", urlPatterns = { "/UserServlet.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		response.setContentType("text/plain;charset=utf-8");
		if (action==null)
			action="list";
		
		//列表
		if (action.equals("list")){
			doList(request,response);
			return;
		}
		
		//删除
		if (action.equals("delete")){
			doDel(request, response);
			return;
		}
		
		//添加
		if (action.equals("save")){
			doAdd(request, response);
			return;
		}
		
		//修改
		if (action.equals("updateRole")){
			doUpdateRole(request, response);
			return;
		}
		
		//锁定
		if(action.equals("lock"))
		{
			doLocked(request,response);
		}
		if(action.equals("updatePW"))
		{
			doUpdatePW(request,response);
		}
	}

	private void doUpdateRole(HttpServletRequest request,
			HttpServletResponse response) {

		String userAccount=request.getParameter("userAccount");
		String roleStr=request.getParameter("role");
		int role=0;
		if("管理员".equals(roleStr)) role=0;
		else if("后厨".equals(roleStr)) role=1;
		else if("服务员".equals(roleStr)) role=2;
		UserinfoDao dao=new UserinfoDaoImpl();
		Map<String, Object> res=new HashMap<String,Object>();
		if(dao.updateRole(userAccount, role)==1)
		{
			res.put("success", "OK");
		}
		else {
			res.put("errMsg","修改失败");
		}
		writeJson(response, JsonUtil.getJsonString(res));
	}
	private void doUpdatePW(HttpServletRequest request,
			HttpServletResponse response)
		{
			String userAccount=request.getParameter("userAccount");
			String userPass=request.getParameter("userPass");
			userPass=Md5Utils.md5(userPass);
			UserinfoDao dao=new UserinfoDaoImpl();
			Map<String, Object> res=new HashMap<String,Object>();
			if(dao.updatePW(userAccount,userPass)==1)
			{
				res.put("success", "OK");
			}
			else {
				res.put("errMsg","修改失败");
			}
			writeJson(response, JsonUtil.getJsonString(res));
		}
	private void doAdd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(request.getParameter("userId"));
		String userAccount=request.getParameter("userAccount");
		String roleStr=request.getParameter("role");
		int role=2;
		if("管理员".equals(roleStr)) role=0;
		else if("后厨".equals(roleStr)) role=1;
		else if("服务员".equals(roleStr)) role=2;
		String userPass=request.getParameter("userPass");
		userPass=Md5Utils.md5(userPass);
		int locked=0;
		if("on".equals(request.getParameter("locked")))
			locked=1;
		Userinfo user=new Userinfo(userId, role, locked,null, userAccount, userPass);
		UserinfoDao dao=new UserinfoDaoImpl();
		Map<String, Object> res=new HashMap<String,Object>();
		if(dao.insert(user)==1)
		{
			res.put("success", "OK");
		}
		else {
			res.put("errMsg","修改失败");
		}
		writeJson(response, JsonUtil.getJsonString(res));
	}

	private void doDel(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userAccout=request.getParameter("userAccount");
		UserinfoDao dao=new UserinfoDaoImpl();
		Map<String, Object> res=new HashMap<String,Object>();
		if(dao.delete(userAccout)==1)
		{
			res.put("success", "OK");
		}
		else {
			res.put("errMsg","修改失败");
		}
		writeJson(response, JsonUtil.getJsonString(res));
			
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) {
		String spageNum=request.getParameter("page");
		String spageSize=request.getParameter("rows");
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		int pageNum,pageSize;
		if (spageNum==null)
			pageNum=1;
		else {
			pageNum=Integer.parseInt(spageNum);
		}
		if (spageSize==null)
			pageSize=10;
		else {
			pageSize=Integer.parseInt(spageSize);
		}
		String orderClause=null;
		if (sort!=null)
			orderClause=sort+" "+order;
		List<Userinfo> list=null;
		String jsonReStr=null;
		Map<String,Object> map=new HashMap<String,Object>();
		UserinfoDao dao=new UserinfoDaoImpl();
		list=dao.findAll(null,orderClause, pageSize, pageNum);
		map.put("rows",list);
		map.put("total",dao.total());
		jsonReStr=JsonUtil.getJsonString(map);
		writeJson(response,jsonReStr);
	}
	private void doLocked(HttpServletRequest request, HttpServletResponse response)
	{
		String userAccout=request.getParameter("userAccount");
		UserinfoDao dao=new UserinfoDaoImpl();
		Map<String, Object> res=new HashMap<String,Object>();
		if(dao.locked(userAccout)==1)
		{
			res.put("success", "OK");
		}
		else {
			res.put("errMsg","加/解锁失败");
		}
		writeJson(response, JsonUtil.getJsonString(res));
	}
	private void writeJson(HttpServletResponse response,String o){
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out=response.getWriter();
			out.write(o);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
