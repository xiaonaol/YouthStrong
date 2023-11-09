package xyz.zrxjuly.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import xyz.zrxjuly.pojo.*;
import xyz.zrxjuly.service.IBookService;
import xyz.zrxjuly.service.IChildrenService;
import xyz.zrxjuly.service.IUserService;

/**
 * 管理员端
 * @author zhangrongxiang
 *
 */
@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private IUserService userService;

	@Resource
	private IBookService bookService;

	@Resource
	private IChildrenService childrenService;
	
	/** 主页显示 **/
	@RequestMapping("main")
	public String toMain() {
		return "admin/user_index";
	}
	
	/** 用户列表 **/
	@RequestMapping("userList")
	public String userList(Model model) {
		List<User> userList = userService.getAllUser();
		model.addAttribute("userList", userList);
		return "admin/user_list";
	}
	
	/** 待审核的图书 **/
	@RequestMapping("toBookCheck_0")
	public String toBookCheck_0(Model model) {
		List<Book> bookList = bookService.adminGetBookCheck_0();
		model.addAttribute("bookList", bookList);
		return "admin/book_check0";
	}
	
	/** 通过审核的图书--待用户捐赠 **/
	@RequestMapping("toBookCheck_1")
	public String toBookCheck_1(Model model) {
		List<Book> bookList = bookService.adminGetBookCheck_1();
		model.addAttribute("bookList", bookList);
		return "admin/book_check1";
	}
	
	/** 未通过审核的图书  **/
	@RequestMapping("toBookCheck_2")
	public String toBookCheck_2(Model model) {
		List<Book> bookList = bookService.adminGetBookCheck_2();
		model.addAttribute("bookList", bookList);
		return "admin/book_check2";
	}
	
	/** 管理员删除用户 **/
	@RequestMapping("adminDelUserByUserId")
	@ResponseBody
	public JSONObject adminDelUserByUserId(String u_id, HttpSession session) {
		JSONObject json = new JSONObject();
		int delUser = userService.adminDelUserByUserId(u_id);
		if (delUser > 0) {
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 用户列表 **/
	@RequestMapping("toAdminEditUser")
	public String toAdminEditUser(String u_id, Model model) {
		User user = userService.adminGetUserById(u_id);
		model.addAttribute("user", user);
		return "admin/edit_userinfo";
	}
	
	/** 管理员-修改用户信息 **/
	@RequestMapping("adminEditUserInfo")
	@ResponseBody
	public JSONObject adminEditUserInfo(User user) {
		JSONObject json = new JSONObject();
		if (user != null) {
			userService.editUserInfo(user);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-待审核-审核不通过 **/
	@RequestMapping("adminCheckNo")
	@ResponseBody
	public JSONObject deleteCheck0(String b_id) {
		JSONObject json = new JSONObject();
		if (b_id != null) {
			bookService.adminCheckNo(b_id);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-删除未通过审核的图书信息 **/
	@RequestMapping("adminDelCheck2")
	@ResponseBody
	public JSONObject adminDelCheck2(String b_id) {
		JSONObject json = new JSONObject();
		if (b_id != null) {
			bookService.deleteCheck0(b_id);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员 审核图书-通过审核 **/
	@RequestMapping("adminCheck_0Success")
	@ResponseBody
	public JSONObject adminCheck_0Success(String b_id) {
		JSONObject json = new JSONObject();
		if (b_id != null) {
			bookService.adminCheck_0Success(b_id);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-用户已将图书捐赠给图书馆 **/
	@RequestMapping("adminCheck_3Success")
	@ResponseBody
	public JSONObject adminCheck_3Success(String b_id) {
		JSONObject json = new JSONObject();
		if (b_id != null) {
			bookService.adminCheck_3Success(b_id);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-查询用户捐赠成功的记录 **/
	@RequestMapping("donation_history")
	public String donation_history(Model model) {
		List<Book> bookList = bookService.getDonationBook();
		model.addAttribute("bookList", bookList);
		return "admin/book_history";
	}

	/** 管理员-查询用户捐赠成功的记录 **/
	@RequestMapping("assign")
	public String assign(Model model) {
		List<Book> bookList = bookService.getDonationBook();
		List<Children> childrenList=childrenService.adminGetChildren();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String childrenListJson = objectMapper.writeValueAsString(childrenList);
			model.addAttribute("childrenListJson", childrenListJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("bookList", bookList);
		model.addAttribute("childrenList", childrenList);
		return "admin/assign";
	}

	/**分配物资**/
	@RequestMapping("assign_materials")
	@ResponseBody
	public void assign_materials(@RequestBody MaterialsAssignmentRequest materialsAssignmentRequest) {
		String childrenAccount=materialsAssignmentRequest.getChildrenAccount();
		int quantity=materialsAssignmentRequest.getQuantity();
		String b_name=materialsAssignmentRequest.getB_name();
		bookService.deleteMaterials(quantity,b_name);
		bookService.addMaterialsInfor(quantity,b_name,childrenAccount);
		return ;
	}
}
