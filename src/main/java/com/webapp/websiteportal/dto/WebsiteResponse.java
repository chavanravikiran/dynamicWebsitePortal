package com.webapp.websiteportal.dto;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.webapp.websiteportal.entity.FeatureMenu;
import com.webapp.websiteportal.entity.WebSiteDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebsiteResponse extends MessageResponse{
	
	private static final long serialVersionUID = 5820582155836361527L;

	private Long key;
	
	private String websiteName;
	
	private String websiteNameMr;
	
	private String oldWebsiteLink;

	private String websiteLogo;
	
	private String webSiteType;
	
	public static WebsiteResponse init(Optional<WebSiteDetails> webSiteDetails) {
		return WebsiteResponse.builder()
				.key(webSiteDetails.get().getKey())
				.websiteName(webSiteDetails.get().getWebsiteName())
				.websiteNameMr(webSiteDetails.get().getWebsiteNameMr())
				.oldWebsiteLink(webSiteDetails.get().getOldWebsiteLink())
				.websiteLogo(webSiteDetails.get().getWebsiteLogo())
				.status(ServiceStatus.SUCCESS)
				.build();
	}
}
