package com.baizhi.hlp.service;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baizhi.hlp.dao.ChapterDAO;
import com.baizhi.hlp.entity.Chapter;

@Service
public class ChapterServiceImpl implements ChapterService{

	@Resource
	private ChapterDAO chapterDAO;
	
	@Override
	public void insert(Chapter chapter) {
		chapter.setId(UUID.randomUUID().toString());
		chapter.setPub_date(new Date());
		chapterDAO.insert(chapter);
	}

}
