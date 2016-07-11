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
import model.dishInfo;
import util.JsonUtil;
import dao.UserinfoDao;
import dao.UserinfoDaoImpl;
import dao.dishesInfoDao;
import dao.dishesInfoDaoImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(name = "DishServlet.do", urlPatterns = { "/DishServlet.do" })
public class DishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishServlet() {
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
		if(action==null)
			action="list";
		if (action.equals("list")){
			doList(request,response);
			return;
		}else if(action.equals("save")){
			doAdd(request,response);
		}else if(action.equals("update")){
			doUpdate(request,response);
		}else if(action.equals("delete")){
			doDel(request,response);
		}
	}

	private void doDel(HttpServletRequest request, HttpServletResponse response) {
		String dishId = request.getParameter("dishesId");	
		dishesInfoDao dDao = new dishesInfoDaoImpl();
		Map<String,Object> res = new HashMap<String,Object>();
		if(dishId==null){
			res.put("errMsg", "ÐÞ¸ÄÊ§°Ü");
			
		}
		else{
			int dishesId = Integer.parseInt(dishId);
			//System.out.println(dishesId);
			dDao.delete(dishesId);
			res.put("success", "OK");
			
		}
		writeJson(response, JsonUtil.getJsonString(res));
		
	}

	private void doUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		String dishId = request.getParameter("dishesId");
		int dishesId = Integer.parseInt(dishId);
		String dishesName = request.getParameter("dishesName");
		String dishesImg = request.getParameter("dishesImg");
		String dishesDiscript = request.getParameter("dishesDiscript");
		String dishesTxt = request.getParameter("dishesTxt");
		int recommend = Integer.parseInt(request.getParameter("recommend"));
		String dishesPriceS = request.getParameter("dishesPrice");
		float dishesPrice = Float.parseFloat(dishesPriceS);
		dishInfo dish = new dishInfo(dishesId, dishesName, dishesDiscript, dishesImg, dishesTxt, recommend, dishesPrice);
	    dishesInfoDao dDao = new dishesInfoDaoImpl();
		Map<String,Object> res  = new HashMap<String,Object>();
	
		if(dishesName==null){
			res.put("errMsg", "ÐÞ¸ÄÊ§°Ü");
			
		}else{
			
			dDao.update(dish);
			res.put("success", "OK");
		}
		writeJson(response, JsonUtil.getJsonString(res));
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response) {
		String dishId = request.getParameter("dishesId");
		int dishesId = Integer.parseInt(dishId);
		String dishesName = request.getParameter("dishesName");
		String dishesImg = request.getParameter("dishesImg");
		String dishesDiscript = request.getParameter("dishesDiscript");
		String dishesTxt = request.getParameter("dishesTxt");
		int recommend = Integer.parseInt(request.getParameter("recommend"));
		String dishesPriceS = request.getParameter("dishesPrice");
		float dishesPrice = Float.parseFloat(dishesPriceS);
		dishInfo dish = new dishInfo(dishesId, dishesName, dishesDiscript, dishesImg, dishesTxt, recommend, dishesPrice);
		dishesInfoDao dDao  = new dishesInfoDaoImpl();
		System.out.println("dsdsdsd");
		Map<String,Object> res  = new HashMap<String,Object>();
		if(dDao.insert(dish) == 1){
			res.put("success", "OK");
		}else{
			res.put("errMsg", "ÐÞ¸ÄÊ§°Ü");
		}
		writeJson(response, JsonUtil.getJsonString(res));
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
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
		List<dishInfo> list=null;
		String jsonReStr=null;
		Map<String,Object> map=new HashMap<String,Object>();
		dishesInfoDao dao=new dishesInfoDaoImpl();
		list=dao.getList(null,orderClause, pageSize, pageNum);
		map.put("rows",list);
		map.put("total",dao.total());
		jsonReStr=JsonUtil.getJsonString(map);
		//System.out.println(jsonReStr);
		writeJson(response,jsonReStr);
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
