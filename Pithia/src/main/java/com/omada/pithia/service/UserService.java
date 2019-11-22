package com.omada.pithia.service;

import com.omada.pithia.domain.xrhstes.Foititis;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional
@Repository
@Service
public class UserService {


	public final List<Foititis> createAccounts(int numberOfAccounts) {
		return Collections.emptyList();
	}

}
