package com.baizhi.hlp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.hlp.dao.BannerDAO;
import com.baizhi.hlp.entity.Banner;

@Service
@Transactional
public class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerDAO bannerDAO;
	
	//分页查询
	@Override
	public List<Banner> queryPaging(Integer page,Integer count) {
		//进行计算每页开始展示第几条
		int begin = (page-1)*count;
		
		return bannerDAO.queryPaging(begin,count);
	}

	@Override
	public int count() {
		return bannerDAO.count();
	}

	@Override
	public void update(String id, String status) {
		bannerDAO.update(id, status);
	}

	@Override
	public void insert(Banner banner) {
		//banner.setPub_data(new Date());
		banner.setId(UUID.randomUUID().toString());
		bannerDAO.insert(banner);
	}

	@Override
	public void delete(String id) {
		bannerDAO.delete(id);
	}

}
