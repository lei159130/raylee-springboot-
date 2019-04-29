package com.lee1314.raylee.modules.audio.service.impl;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lee1314.raylee.modules.audio.dao.mapping.PeopleDailyDao;
import com.lee1314.raylee.modules.audio.model.PeopleDaily;
import com.lee1314.raylee.modules.audio.service.PeopleDailyService;
import com.lee1314.raylee.utils.EncryDecryUtils;

/**
 * 人民日报ServiceImpl
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:09:42
 */
@Service
public class PeopleDailyServiceImpl implements PeopleDailyService {

	@Value("${system.encode}")
	private String enc;
	@Autowired
	private PeopleDailyDao mapper;

	@Override
	public PeopleDaily findById(Long id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Long findNewID(Integer seminarId) {
		return mapper.selectNewId(seminarId);
	}

	@Override
	public Long findPrevId(Long id, Integer seminarId) throws Exception {
		return mapper.selectPrevId(id, seminarId);
	}

	@Override
	public Long findNextId(Long id, Integer seminarId) throws Exception {
		return mapper.selectNextId(id, seminarId);
	}

	@Override
	public String findEncodePrevId(Long id, Integer seminarId) throws Exception {
		Long prev = findPrevId(id, seminarId);
		if (prev == null)
			return null;

		return URLEncoder.encode(URLEncoder.encode(EncryDecryUtils.Encry(String.valueOf(prev)), enc), enc);
	}

	@Override
	public String findEncodeNextId(Long id, Integer seminarId) throws Exception {
		Long next = findNextId(id, seminarId);
		if (next == null)
			return null;

		return URLEncoder.encode(URLEncoder.encode(EncryDecryUtils.Encry(String.valueOf(next)), enc), enc);
	}

}
