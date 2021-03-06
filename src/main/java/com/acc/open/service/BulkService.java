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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.acc.open.model.AoAccountInfo;
import com.acc.open.model.AoAccountInfoPK;
import com.acc.open.model.AoBulkDetail;
import com.acc.open.model.AoBulkFile;
import com.acc.open.model.AoCustomerInfo;
import com.acc.open.model.AoStatusFile;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BulkService {
	@Value("${spring.datasource.url}")
	private String restURI;

	@Autowired
	LogingService loginService;

	@Autowired
	CustomerService customerService;

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

	public AoBulkFile getBulkFileById(String id) {
		AoBulkFile bulkFile = null;
		final String uri = restURI + "/api/bulkfiles/{id}";
		try {
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			ResponseEntity<AoBulkFile> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<AoBulkFile>() {
					}, params);
			bulkFile = response.getBody();
		} catch (HttpClientErrorException e) {

		}

		return bulkFile;
	}

	public HttpStatus addBulkDetailFile(AoBulkDetail bulkDetailfile, Long id_file) {
		final String uri = restURI + "/api/bulkfiles/" + id_file.toString() + "/files/";
		HttpStatus stat = HttpStatus.OK;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<AoBulkDetail> response = restTemplate.postForEntity(uri, bulkDetailfile, AoBulkDetail.class);
			if(response.getStatusCode().equals(HttpStatus.OK)){
				stat = response.getStatusCode();
			}
		} catch (HttpClientErrorException e) {
			if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				stat = e.getStatusCode();
			}
		}
		return stat;
	}

	public HttpStatus addBulkFile(AoBulkFile bulkfile) {
		final String uri = restURI + "/api/bulkfiles/";
		HttpStatus stat = HttpStatus.OK;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<AoBulkFile> response = restTemplate.postForEntity(uri, bulkfile, AoBulkFile.class);
			if(response.getStatusCode().equals(HttpStatus.OK)){
				stat = response.getStatusCode();
			}

		} catch (HttpClientErrorException e) {
			if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				stat = e.getStatusCode();
			}
		}
		return stat;

	}

	public void updateBulkFile(AoBulkFile bulkfile, String statusCode) {
		final String uri = restURI + "/api/bulkfiles/";
		AoStatusFile aoStatusFile = new AoStatusFile();
		aoStatusFile.setCode(statusCode);
		bulkfile.setAoStatusFile(aoStatusFile);
		try {
			Map<String, String> param = new HashMap<String, String>();
			HttpHeaders headers = new HttpHeaders();

			HttpEntity<AoBulkFile> requestEntity = new HttpEntity<AoBulkFile>(bulkfile, headers);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.exchange(uri, HttpMethod.PUT, requestEntity, AoBulkFile.class, param);

		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}

	}

	public List<AoBulkDetail> readFile(MultipartFile file) throws IOException {
		List<AoBulkDetail> bulkFiles = new ArrayList<>();

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String jsonData = new String(bytes,"UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				bulkFiles = mapper.readValue(jsonData, new TypeReference<List<AoBulkDetail>>() {
				});
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

	public AoBulkFile CreateAccountBulkFiles(String[] id) {
		final String uri = restURI + "/api/bulkfiles/{id}/files/";
		List<AoBulkDetail> bulkDetails = new ArrayList<AoBulkDetail>();
		AoBulkFile aoFileResult = new AoBulkFile();
		int errorCount = 0;
		int successCount = 0;
		try {
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			for (int i = 0; i < id.length; i++) {
				params.put("id", id[i]);
				ResponseEntity<List<AoBulkDetail>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<AoBulkDetail>>() {
						}, params);

				// Loop create accounts for each files
				bulkDetails = response.getBody();

				successCount = 0;
				errorCount = 0;

				for (int j = 0; bulkDetails != null && j < bulkDetails.size(); j++) {
					HttpStatus stat = createAccount(bulkDetails.get(j));
					if (stat.equals(HttpStatus.OK)) {
						successCount = successCount + 1;
					} else {
						errorCount = errorCount + 1;
					}
				}

				if (bulkDetails != null && bulkDetails.size() > 0) {
					aoFileResult = bulkDetails.get(0).getAoBulkFile();

					Date curDate = new Date();
					aoFileResult.setProcessDate(curDate);
					aoFileResult.setApprovedBy(String.valueOf(loginService.getUserLogin().getUserId()));
					aoFileResult.setTotalRejected(new BigDecimal(errorCount));
					aoFileResult.setTotalCompleted(new BigDecimal(successCount));

					if (errorCount == 0) {
						updateBulkFile(aoFileResult, "03"); // Success
					} else if (errorCount > 0) {
						updateBulkFile(aoFileResult, "04"); // process with error
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aoFileResult;
	}

	private HttpStatus createAccount(final AoBulkDetail b) {

		HttpStatus status = HttpStatus.OK;
		try {

			final String uri = restURI + "/api/customers/" + b.getCifNo().toString() + "/accounts/";
			RestTemplate restTemplate = new RestTemplate();

			AoAccountInfo a = new AoAccountInfo();
			AoAccountInfoPK ap = new AoAccountInfoPK();
			ap.setAcNo((Long.parseLong(b.getAcNo().toString())));
			ap.setCifNo(Long.parseLong(b.getCifNo().toString()));
			a.setId(ap);

			a.setAcBrno(b.getAcBranch());
			a.setAcIntrate(new BigDecimal(0.75));//

			Date curDate = new Date();
			a.setAcOpendate(curDate);
			a.setAcPassbookNo(b.getAcBranch() + "-" + b.getAcNo().toString().substring(0, 5)); // Using brcd - acct no
			a.setAcRestFlag("1");
			a.setAcStatus("0");
			a.setAccountType(b.getAcProductType()); // default to SAV
			a.setAtmNumber(""); // Branch + account no
			a.setClosedDate(null);
			a.setProductType(b.getAcProductType());
			a.setBalance(BigDecimal.ZERO);
			restTemplate.postForEntity(uri, a, AoAccountInfo.class);

		} catch (HttpClientErrorException e) {
			if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				e.printStackTrace();
			}

			status = e.getStatusCode();
		}
		return status;
	}

	private boolean validateAccount(final AoBulkDetail b) {

		boolean isPass = true;
		// Check CIF must not be null
		if (b.getCifNo() == null) {
			isPass = false;
		}

		// Check CIF is existed ?
		if (isPass && !b.getCifNo().toString().equals("")) {
			try {
				AoCustomerInfo customer = customerService.getCustomerById(b.getCifNo().toString());
				if (customer == null) {
					isPass = false;
				}
			} catch (HttpClientErrorException e) {
				if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
					isPass=false;
				}
			}
		}
		return isPass;
	}

	public AoBulkFile validateAccountBulkFiles(String[] id) {
		final String uri = restURI + "/api/bulkfiles/{id}/files/";
		List<AoBulkDetail> bulkDetails = new ArrayList<AoBulkDetail>();
		AoBulkFile aoFileResult = new AoBulkFile();
		int errorCount = 0;
		int successCount = 0;
		try {
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			for (int i = 0; i < id.length; i++) {
				params.put("id", id[i]);
				ResponseEntity<List<AoBulkDetail>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<AoBulkDetail>>() {
						}, params);

				// Loop validate accounts for each files
				bulkDetails = response.getBody();

				successCount = 0;
				errorCount = 0;

				for (int j = 0; bulkDetails != null && j < bulkDetails.size(); j++) {
					boolean isPass = validateAccount(bulkDetails.get(j));
					if (isPass) {
						successCount = successCount + 1;
					} else {
						errorCount = errorCount + 1;
					}
				}

				if (bulkDetails != null && bulkDetails.size() > 0) {
					aoFileResult = bulkDetails.get(0).getAoBulkFile();

					Date curDate = new Date();
					aoFileResult.setProcessDate(curDate);
					aoFileResult.setApprovedBy(String.valueOf(loginService.getUserLogin().getUserId()));
					aoFileResult.setTotalFailed(new BigDecimal(errorCount));
					aoFileResult.setTotalPassed(new BigDecimal(successCount));

					if (errorCount == 0) {
						updateBulkFile(aoFileResult, "02"); // validate passed, waiting for create accounts
					} else if (errorCount > 0) {
						updateBulkFile(aoFileResult, "05"); // validate failed, rejected
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aoFileResult;
	}

}
