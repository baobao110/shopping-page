package com.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajax.ajaxDAO;
import com.domain.commodity;
import com.domain.shopcart;
import com.dto.cartDTO;
import com.service.cartServer;

@RestController
@RequestMapping("/cart")
public class cartControl {
	
	@Autowired
	private cartServer cart;
	
	@RequestMapping("/addCart")
	public ajaxDAO add(int commodityId,int commodityNum) {
		int userId=11;
		try {
			cart.add(commodityId, commodityNum, userId);
			return ajaxDAO.success();
		}
		catch (Exception e) {
			// TODO: handle exception
			return ajaxDAO.failure(e.getMessage());
		}
	}
	
	@RequestMapping("/getNum")
	public ajaxDAO getNum() {
		int userId=11;
		int num=cart.getNum(userId);
		return ajaxDAO.success(num);
	}
	
	@RequestMapping("/detail")
	public ajaxDAO detail() {
		int userId=11;
		cartDTO dto=cart.detail(userId,1);
		return ajaxDAO.success(dto);
	}
	
	@RequestMapping("/detail2")
	public ajaxDAO detail2() {
		int userId=11;
		cartDTO dto=cart.detail(userId,2);
		return ajaxDAO.success(dto);
	}
	
	@RequestMapping("/delete")
	public  ajaxDAO delete(int id) {
		int userId=11;
		try {
			cart.delete(id, userId);
			return ajaxDAO.success();
		}
		catch (Exception e) {
			// TODO: handle exception
			return ajaxDAO.failure(e.getMessage());
		}
	}
	
	
	@RequestMapping("/result")
	@ResponseBody
	public ajaxDAO result(@RequestBody String str) {
		System.out.println("str-------------------"+str+"}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}]s");
		String[]x=str.trim().split("\\;");//ע������Ϊʲô��trim()����Ϊǰ�˴��ݵ����ݿ��ܻ���ֿո�����,��ʱ��ǰ�˿�������,�������ͨ����̨�������ӡ�鿴 
		try {
			for(int i=0;i<x.length;i++) {
				System.out.println("LLLLLLLLLLLLLLLLLLL"+i+"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
				cart.update(x[i]);
			}
			return ajaxDAO.success();
		}catch (Exception e) {
			// TODO: handle exception
			return ajaxDAO.failure(e.getMessage());
		}
		
	}

}
