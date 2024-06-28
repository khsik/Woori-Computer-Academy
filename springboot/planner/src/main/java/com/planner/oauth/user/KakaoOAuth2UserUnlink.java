package com.planner.oauth.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
//TODO - unlink 기능을 사용하려면 Https 가 필수이기에 형식만 갖춰놓았다 추후 SSL발급 해볼예정
public class KakaoOAuth2UserUnlink implements OAuth2UserUnlink {
    private static final String URL = "https://kapi.kakao.com/v1/user/unlink";
    private final RestTemplate restTemplate;
    
	@Override
	public void unlink(String accessToken) {
	     HttpHeaders headers = new HttpHeaders();
	        headers.setBearerAuth(accessToken);
	        HttpEntity<Object> entity = new HttpEntity<>("", headers);
	        restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);

	}

}
