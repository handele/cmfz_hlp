package com.baizhi.hlp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.hlp.dao.GuruDAO;
import com.baizhi.hlp.entity.Guru;

@Service
public class GuruServiceImpl implements GuruService{

	@Autowired
	private GuruDAO guruDAO;
	
	@Override
	public List<Guru> queryGuru(Integer page, Integer rows) {
		int begin = (page-1)*rows;
		return guruDAO.queryGuru(begin, rows);
	}

	@Override
	public int count() {
		return guruDAO.count();
	}

	@Override
	public void guruUpdate(String id, String status) {
		guruDAO.guruUpdate(id, status);
		
	}

}
