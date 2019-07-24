package com.baizhi.hlp.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baizhi.hlp.dao.AlbumDAO;
import com.baizhi.hlp.entity.Album;


@Service
public class AlbumServiceImpl implements AlbumService{

	@Resource
	private AlbumDAO albumDAO;
	
	@Override
	public void insertAlbum(Album album) {
		album.setPub_date(new Date());
		album.setId(UUID.randomUUID().toString());
		album.setScore(2);
		album.setCount(0);
		albumDAO.insertAlbum(album);
	}

	@Override
	public List<Album> queryPaging(Integer begin, Integer end) {
		int beg = (begin-1)*end;
		return albumDAO.queryPaging(beg, end);
	}

	@Override
	public int count() {
		return albumDAO.count();
	}

}
