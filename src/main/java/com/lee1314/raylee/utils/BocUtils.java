package com.lee1314.raylee.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidubce.Protocol;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;

@Component
public class BocUtils {

	public static String bucketname;
	private static String accessKeyId;
	private static String secretAccessKey;
	private static String endpoint;
	private static BosClient client;

	public static BosClient getInstance() {
		if (client == null) {
			BosClientConfiguration config = new BosClientConfiguration();
			config.setCredentials(new DefaultBceCredentials(accessKeyId, secretAccessKey));
			config.setMaxConnections(10);
			config.setConnectionTimeoutInMillis(5000);
			config.setSocketTimeoutInMillis(2000);
			config.setEndpoint(endpoint);
			config.setProtocol(Protocol.HTTPS);
			client = new BosClient(config);
		}
		return client;
	}

	@Value("${boc.bucketname}")
	public void setBucketname(String bucketname) {
		BocUtils.bucketname = bucketname;
	}

	@Value("${boc.access.key.id}")
	public void setAccessKeyId(String accessKeyId) {
		BocUtils.accessKeyId = accessKeyId;
	}

	@Value("${boc.secret.access.key}")
	public void setSecretAccessKey(String secretAccessKey) {
		BocUtils.secretAccessKey = secretAccessKey;
	}

	@Value("${boc.endpoint}")
	public void setEndpoint(String endpoint) {
		BocUtils.endpoint = endpoint;
	}
}
