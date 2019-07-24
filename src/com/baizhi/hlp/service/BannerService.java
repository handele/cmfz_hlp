package com.baizhi.hlp.service;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import com.baizhi.hlp.entity.Banner;

public interface BannerService {

	//分页展示所有
	public List<Banner> queryPaging(Integer page,Integer count);
	
	//查询总条数
	public int count();
	
	//修改冻结状态
	public void update(@Param("id")String id,@Param("status")String status);
	
	//添加轮播图
	public void insert(Banner banner);

	//删除
	public void delete(String id);
}
