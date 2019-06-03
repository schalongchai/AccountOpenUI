package com.acc.open.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.acc.open.model.AoBulkDetail;
import com.acc.open.model.AoBulkFile;
import com.acc.open.model.AoStatusFile;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BulkService {
	@Value("${spring.datasource.url}")
	private String restURI;

	@Autowired
	LogingService loginService;

	public List<AoBulkFile> getAllBulks() {
		List<AoBulkFile> bulkFile = null;
		final String uri = restURI + "/api/bulkfiles/";
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<List<AoBulkFile>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<AoBulkFile>>() {
					});
			bulkFile = response.getBody();
		} catch (HttpClientErrorException e) {

		}

		return bulkFile;
	}

	public void addBulkDetailFile(AoBulkDetail bulkfile, Long id_file) {
		final String uri = restURI + "/api/bulkfiles/" + id_file.toString() + "/files/";
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity(uri, bulkfile, AoBulkDetail.class);
		} catch (HttpClientErrorException e) {

		}

	}

	public void addBulkFile(AoBulkFile bulkfile) {
		final String uri = restURI + "/api/bulkfiles/";
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity(uri, bulkfile, AoBulkFile.class);

		} catch (HttpClientErrorException e) {

		}

	}

	public List<AoBulkDetail> readFile(MultipartFile file) throws IOException {
		List<AoBulkDetail> bulkFiles = new ArrayList<>();

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String jsonData = new String(bytes);
				ObjectMapper mapper = new ObjectMapper();
				bulkFiles = mapper.readValue(jsonData, new TypeReference<List<AoBulkDetail>>(){});
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException(e.getMessage());
			} 

		}
		return bulkFiles;

	}

	public AoBulkFile extractBulkFileHeader(String fileName, List<AoBulkDetail> bulkFileDetails) {
		AoBulkFile bulkfile = new AoBulkFile();
		bulkfile.setId(bulkFileDetails.get(0).getId_file());
		bulkfile.setFileName(fileName);
		bulkfile.setApprovedBy("");

		Date curDate = new Date();
		
		bulkfile.setUploadDate(curDate);

		bulkfile.setTotalCompleted(BigDecimal.ZERO);
		bulkfile.setTotalFailed(BigDecimal.ZERO);
		bulkfile.setTotalPassed(BigDecimal.ZERO);
		bulkfile.setTotalRec(new BigDecimal(bulkFileDetails.size()));
		bulkfile.setTotalRejected(BigDecimal.ZERO);
		bulkfile.setUploadBy(String.valueOf(loginService.getUserLogin().getUserId()));

		AoStatusFile stat = new AoStatusFile();
		stat.setCode("01");

		bulkfile.setAoStatusFile(stat);

		return bulkfile;
	}

	public void deleteBulkFiles(String[] id) {
		final String uri = restURI + "/api/bulkfiles/{id}";
		try {
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			for (int i = 0; i < id.length; i++) {
				params.put("id", id[i]);
				ResponseEntity<AoBulkFile> response = restTemplate.exchange(uri, HttpMethod.DELETE, null,
						new ParameterizedTypeReference<AoBulkFile>() {
						}, params);

				response.getBody();

			}
		} catch (HttpClientErrorException e) {

		}

	}
}
