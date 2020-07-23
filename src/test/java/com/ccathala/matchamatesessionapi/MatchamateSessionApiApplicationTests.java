package com.ccathala.matchamatesessionapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.ccathala.matchamatesessionapi.dao.SessionDao;
import com.ccathala.matchamatesessionapi.model.Session;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MatchamateSessionApiApplicationTests {

	@Autowired
	private SessionDao sessionDao;

	@Test
	void checkCollection() {
		List<Session> sessions = sessionDao.findAll();
		assertThat(sessions.size()).isEqualTo(1);
	}

}
