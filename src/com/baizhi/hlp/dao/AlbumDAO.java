package com.baizhi.hlp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.hlp.entity.Album;

public interface AlbumDAO {
	
	//添加专辑
	public void insertAlbum(Album album); 
	
	//分页查询
	public List<Album> queryPaging(@Param("begin")Integer begin,@Param("end")Integer end);

	//查询总条数
	public int count();
}
