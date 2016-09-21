package com.shun.blog.model.user.api;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

public class Authentication {
	public static HttpResponse executeGet(HttpTransport transport, JsonFactory jsonFactory, String accessToken, GenericUrl url) throws IOException {
		Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod()).setAccessToken(accessToken);
		HttpRequestFactory requestFactory = transport.createRequestFactory(credential);
		return requestFactory.buildGetRequest(url).execute();
	}
	  
	public void OauthAccessToken(HttpTransport transport, JsonFactory jsonFactory) throws GeneralSecurityException, IOException{ 
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
			    .setAudience(Arrays.asList("264714905099-kta7i5n1lrmlrfbsmp7vi5g6or0e3n3d"))
			    .setIssuer("https://accounts.google.com")
			    .build();
			// (Receive idTokenString by HTTPS POST)
			String idTokenString=verifier.getIssuer();
			
			GoogleIdToken idToken = verifier.verify(idTokenString);
			if (idToken != null) {
			  Payload payload = idToken.getPayload();

			  // Print user identifier
			  String userId = payload.getSubject();
			  System.out.println("User ID: " + userId);

			  // Get profile information from payload
			  String email = payload.getEmail();
			  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			  String name = (String) payload.get("name");
			  String pictureUrl = (String) payload.get("picture");
			  String locale = (String) payload.get("locale");
			  String familyName = (String) payload.get("family_name");
			  String givenName = (String) payload.get("given_name");

			  // Use or store profile information
			  // ...

			} else {
			  System.out.println("Invalid ID token.");
			}
	}

}
