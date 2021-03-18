package com.miniblog.service;

import java.util.List;

import com.miniblog.model.dto.StatusDTO;
import com.miniblog.model.dto.StatusInfoDTO;

public interface StatusService {

	List<StatusInfoDTO> getAllStatus();
	void addStatus(StatusDTO statusDTO);
	void deleteStatus(long id);
}
